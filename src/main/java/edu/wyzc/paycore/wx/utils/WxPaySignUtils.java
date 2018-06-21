package edu.wyzc.paycore.wx.utils;

import com.github.wxpay.sdk.WXPayConstants;
import edu.wyzc.paycore.wx.constants.WxPayConstants;
import edu.wyzc.paycore.wx.enums.SignType;
import edu.wyzc.paycore.wx.exceptions.UnsupportedSignTypeException;
import edu.wyzc.util.utils.TransferUtils;
import org.xml.sax.SAXException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


/**
 * Created by Allen on 2018/6/13.
 */
public class WxPaySignUtils {

    /**
     * generate md5 signed xml with sign
     *
     * @param data data to sign
     * @param key  sign key
     * @return sign result with the type of xml and with sign
     */
    public static String generateMD5SignedXml(final Map<String, String> data, String key) {
        return generateSignedXml(data, key, SignType.MD5);
    }

    /**
     * 判断签名是否正确
     *
     * @param xmlStr xml data with sign
     * @param key  sign key
     * @return is md5 signature valid. if xmlStr illegal ,return false
     */
    public static boolean isMD5SignatureValid(String xmlStr, String key) {
        Map<String, String> data;
        try {
            data = TransferUtils.standardXml2Map(xmlStr);
        } catch (SAXException e) {
            return false;
        }
        if (!data.containsKey(WXPayConstants.FIELD_SIGN)) {
            return false;
        }
        String sign = data.get(WXPayConstants.FIELD_SIGN);
        return generateSignature(data, key, SignType.MD5).equals(sign);
    }

    /**
     * generate signed xml with sign
     *
     * @param data     data to sign
     * @param key      sign key
     * @param signType sign type
     * @return sign result with the type of xml and with sign
     */
    public static String generateSignedXml(final Map<String, String> data, String key, SignType signType) {
        String sign = generateSignature(data, key, signType);
        data.put(WxPayConstants.FIELD_SIGN, sign);
        return TransferUtils.map2StandardXml(data);
    }

    /**
     * generate signature
     *
     * @param data            data to sign(may contains map key of "sign" and "signType", if contains, these keys didn't involve in signature)
     * @param signKey         sign key
     * @param defaultSignType default sign type, if signType is defined in data, use that
     * @return sign result
     */
    public static String generateSignature(final Map<String, String> data, final String signKey, SignType defaultSignType) {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        SignType signType = defaultSignType;
        for (String key : keyArray) {
            if (key.equalsIgnoreCase(WxPayConstants.FIELD_SIGN)) {
                continue;
            }
            if (key.replace("_", "").equalsIgnoreCase(WxPayConstants.FIELD_SIGN_TYPE)) {
                signType = SignType.valueOf(data.get(key));
            }
            // empty value not involve in signature
            if (data.get(key).trim().length() > 0) {
                sb.append(key).append("=").append(data.get(key).trim()).append("&");
            }
        }
        sb.append("key=").append(signKey);
        if (SignType.MD5 == signType) {
            return MD5(sb.toString()).toUpperCase();
        } else if (SignType.HMACSHA256 == signType) {
            return HMACSHA256(sb.toString(), signKey);
        } else {
            throw new UnsupportedSignTypeException(String.format("Invalid sign_type: %s", signType));
        }
    }

    /**
     * sign with HMACSHA256
     *
     * @param data data to sign
     * @param key  sign key
     * @return sign result
     */
    public static String HMACSHA256(String data, String key) {
        byte[] array;
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * sign with MD5
     *
     * @param data data to sign
     * @return sign result
     */
    public static String MD5(String data) {
        byte[] array;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            array = md.digest(data.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}
