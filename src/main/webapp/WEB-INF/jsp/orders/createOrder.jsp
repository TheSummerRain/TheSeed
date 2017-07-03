<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/6/18 18:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<html>
<head>
    <title>支付下单</title>
</head>
<body>

${wxpay.get("appId")}<br>
${wxpay.get("timeStamp")}<br>
${wxpay.get("nonceStr")}<br>
${wxpay.get("package")}<br>
${wxpay.get("signType")}<br>
${wxpay.get("NATIVE")}<br>
${wxpay.get("paySign")}<br>

<input type="button" value="购买" onclick="onBridgeReady()">

<script>

    function onBridgeReady(){
        WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId":"${wxpay.get("appId")}",     //公众号名称，由商户传入
                    "timeStamp":"${wxpay.get("timeStamp")}",         //时间戳，自1970年以来的秒数
                    "nonceStr":"${wxpay.get("nonceStr")}", //随机串
                    "package":"${wxpay.get("package")}",
                    "signType":"${wxpay.get("signType")}",         //微信签名方式：
                    "paySign":"${wxpay.get("paySign")}" //微信签名
                },
                function(res){
                    if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                        alert("支付成功");
                    }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                }
        );
    }
    if (typeof WeixinJSBridge == "undefined"){
        if( document.addEventListener ){
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        }else if (document.attachEvent){
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
    }else{
        onBridgeReady();
    }


</script>





</body>
</html>
