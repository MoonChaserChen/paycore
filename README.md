## paycore说明文档

#### 系统介绍

	paycore用于支付宝、微信提交支付、订单查询、申请退款相关API的封装

#### maven依赖介绍

	<!-- 封装的一些工具方法，发布于私服中 -->
    <dependency>
        <groupId>edu.wyzc</groupId>
        <artifactId>util</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

#### 支付宝API使用说明

* 初始化
```java
    AlipayClient alipayClient = new DefaultAlipayClient("serverUrl", "appId", "privateKey","format","charset","alipayPublicKey", "signType","proxyHost", "proxyPort");
```

* H5下单
```java
    AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
    model.setTimeoutExpress("超时时间表达式");
    model.setSubject("商品说明");
    model.setOutTradeNo("商户订单号");
    model.setTotalAmount("金额，单位元，格式12.56");
    model.setProductCode("产品码，");
    AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
    request.setBizModel(model);
    request.setReturnUrl("支付完成后跳转页面");
    request.setNotifyUrl("支付结果异步通知地址");
    String payRequestCoreInfo = alipayClient.pageExecute(request).getBody();
```
payRequestCoreInfo示例值：
```
<form name="punchout_form" method="post" action="https://openapi.alipay.com/gateway.do?sign=b7FaYw3CV4Ipdw2GnKbZVlaJ6Wu45hAQo5HnrRmvPU%2FsC%2FBqUYuvCr1s0LqsQFbMDGppXaPtI34NGDXs%2FlTcT4%2BHaVdKOTi3VXkrjYaQ79gr2qLsqLcDVsvnLojDJ7l0Z5u%2Bg3g%2B%2FG%2B77fnF4xNqhB6bPm%2FKeoaxg0NLFRAprwjYNEIyLk55u6ktcAEfK5k0jrJDtyHLqIAIaNPErfTrGS0OPF%2Fyx4Px7f4qipaJiloZE7gMOWp4h74ZVUD8d0outrbW5y74BgryD%2Bu%2BCNvGjY%2BV0kHXWrhJ5TaT7IOU%2BEqna3UkhiS011ih8KFAt2TBdxf3I9PKwNOZ6Iuv1Fc0OQ%3D%3D&timestamp=2018-07-02+11%3A06%3A00&sign_type=RSA2&notify_url=http%3A%2F%2F93fa8070.ngrok.io%2FalipayPayNotify&charset=UTF-8&app_id=2017111709986326&method=alipay.trade.page.pay&return_url=http%3A%2F%2Fwww.baidu.com&version=1.0&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
<input type="hidden" name="biz_content" value="{&quot;out_trade_no&quot;:&quot;1125019519065522432&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,&quot;subject&quot;:&quot;支付中心测试&quot;,&quot;timeout_express&quot;:&quot;15m&quot;,&quot;total_amount&quot;:&quot;0.01&quot;}">
<input type="submit" value="立即支付" style="display:none" >
</form>
<script>document.forms[0].submit();</script>
```
payRequestCoreInfo使用方式：
```java
    @RequestMapping(value="/alipayH5Pay")
    public void alipayPcPay (HttpServletResponse response) {
        // 1. payRequestCoreInfo
        String payRequestCoreInfo = "...";
        // 2. get pay request info and request to pay
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(payRequestCoreInfo);
        response.getWriter().flush();
        response.getWriter().close();
    }
```

* APP下单
``` java
    AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
    model.setTimeoutExpress("超时时间表达式");
    model.setSubject("商品名称");
    model.setOutTradeNo("商户订单号");
    model.setTotalAmount("金额，单位元，格式12.56");
    model.setProductCode("产品码，");
    AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
    request.setBizModel(model);
    request.setNotifyUrl("支付结果异步通知地址");
    String payRequestCoreInfo = alipayClient.sdkExecute(request).getBody();
```
payRequestCoreInfo示例值：
```
alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017111709986326&biz_content=%7B%22out_trade_no%22%3A%221125022030967079168%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%94%AF%E4%BB%98%E4%B8%AD%E5%BF%83%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F93fa8070.ngrok.io%2FalipayPayNotify&sign=cXSd8Uzoyue2FuScmxRpGwoMgjxR6GodRZRjv1pfKUoroOQi%2FBWml4iN8xjWqvzdSK2%2Bd1BEoPIFBO3mnUpNgdUsmr9UYSt0VTO55Ixj%2B6foxxRsrWXm1XduKJuYOFbGKb8nJuhPBnznNVMacCWTXIoWwpndcBNowTbg%2BdGZ4rrAjA3t9k%2Bw%2FSQ2KfmOpB6pMxf3ClSgltC6p5JiwZOMEaIA%2FcU%2BaAML6%2F33yzwJ91vL%2BmnH5%2BAYSboZM0Ds6jfSXWSwGtSdyLc8j7wzL44nX5zq7xgs022URJNNTpGjLs4hj3JUwXKpiV1IQmnCkX4TayY4rwIw48hCA39RhXacqQ%3D%3D&sign_type=RSA2&timestamp=2018-07-02+11%3A15%3A54&version=1.0
```
payRequestCoreInfo使用方式（在APP应用里使用，安卓与IOS使用方式各不相同）：
```
安卓见： https://docs.open.alipay.com/204/105296
IOS见： https://docs.open.alipay.com/204/105295/
```

* PC下单
```java
    AlipayTradePagePayModel model = new AlipayTradePagePayModel();
    model.setTimeoutExpress("超时时间表达式");
    model.setSubject("商品说明");
    model.setOutTradeNo("商户订单号");
    model.setTotalAmount("金额，单位元，格式12.56");
    model.setProductCode("产品码，");
    AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
    request.setBizModel(model);
    request.setReturnUrl("支付完成后跳转页面");
    request.setNotifyUrl("支付结果异步通知地址");
    String payRequestCoreInfo = alipayClient.pageExecute(request).getBody();
```
payRequestCoreInfo示例值：
```
<form name="punchout_form" method="post" action="https://openapi.alipay.com/gateway.do?sign=U6oEvfySZPsdrXZbosmMTgvcrHqhX5PhABeDueKTriGkQk49IHCFCb8aZvCnZtlERZlvLejKXT7SCKbIMpO8MQJRJhwwcnecssbEvFWAcsFLEk02Zhqb9If96REPoo60nTyu1Uj%2BQ2JNNb7V%2BLnYF%2BnHE0u9SDylFLVEFgeXYM%2B9oiM%2BgOGpL81gjNWKUzN9yDid%2BB5lyNsQvGbiYQ7AIQMDj%2FkcSmqvMDu4%2Bf81QVLyRLaus83ZTXJ6hZat27QOYQcNKWGiWdrF6FxiJh01UwLOSmtrZba5fv%2BDpUrlL9UP9IX2dwWEucMhUE7CsRi3uYiVwORLTzc%2FLUrNQGrS5w%3D%3D&timestamp=2018-07-02+11%3A22%3A53&sign_type=RSA2&notify_url=http%3A%2F%2F93fa8070.ngrok.io%2FalipayPayNotify&charset=UTF-8&app_id=2017111709986326&method=alipay.trade.page.pay&return_url=http%3A%2F%2Fwww.baidu.com&version=1.0&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
<input type="hidden" name="biz_content" value="{&quot;out_trade_no&quot;:&quot;1125023758487650560&quot;,&quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,&quot;subject&quot;:&quot;支付中心测试&quot;,&quot;timeout_express&quot;:&quot;15m&quot;,&quot;total_amount&quot;:&quot;0.01&quot;}">
<input type="submit" value="立即支付" style="display:none" >
</form>
<script>document.forms[0].submit();</script>
```
payRequestCoreInfo使用方式：
```java
    @RequestMapping(value="/alipayPcPay")
    public void alipayPcPay (HttpServletResponse response) {
        // 1. payRequestCoreInfo
        String payRequestCoreInfo = "...";
        // 2. get pay request info and request to pay
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(payRequestCoreInfo);
        response.getWriter().flush();
        response.getWriter().close();
    }
```

* 订单状态查询
```java
    AlipayTradeQueryModel model = new AlipayTradeQueryModel();
    model.setOutTradeNo("商户订单号");
    AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
    request.setBizModel(model);
    AlipayTradeQueryResponse response = alipayClient.execute(request);
```
> 更多见支付宝官方文档


#### 微信API使用说明

* 初始化
```java
    WxClient wcClient = DefaultWxClient("mchId","appId","key",byte[] certData,SignType.MD5,"proxyHost","proxyPort");
```

* 支付下单
```java
    WxApiPayRequestModel model = new WxApiPayRequestModel("商品名称", "商户订单号","总金额：单位分", "支付IP", "创建时间", "超时时间", "支付结果异步通知地址", "支付类型");
    WxApiPayRequest request = new WxApiPayRequest(model);
    String payRequestCoreInfo = wxClient.execute(request).getPayRequestCoreInfo();
```
payRequestCoreInfo返回值

| 支付类型 | payRequestCoreInfo示例值 | 使用方式 |
|:------:|:------:|:------:|
|   H5   |https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx20161110163838f231619da20804912345&package=1037687096|拼接redirect_url后跳转，见：https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=15_4|
|  APP   |wx02122819197115adec27a4351641484737|这是prepayId，需要重新签名供APP使用，见：https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=8_5   |
|   PC   |weixin://wxpay/bizpayurl?pr=igUlb14| 做成二维码供网页上扫描 |

* 订单状态查询
```java
	WxApiOrderQueryModel model = new WxApiOrderQueryModel(String.valueOf(outTradeNo));
    WxApiOrderQueryRequest request = new WxApiOrderQueryRequest(model);
    WxApiOrderQueryResponse response = wxClient.execute(request);
```
> 更多API待扩展
