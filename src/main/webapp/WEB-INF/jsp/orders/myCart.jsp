<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/5/28 16:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>


<div class="header">
    <a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <a href="<%=bp%>/home/shouye"
       class="iconfont shopHome"
       style="right:0"></a>
    <h1>购物车</h1>
</div>

<div class="content js_container">

    <c:if test="${null != addrs}">
        <div class="weui_cells weui_cells_access">
            <a class="weui_cell" href="<%=bp%>/addrs/myAddrList"> <!-- 这里应该跳转修改界面 -->
                <div class="weui_cell_hd"><i class="iconfont icon-address mr5"></i></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <p class="b">${addrs.recname}<span class="nb f12 ml10 cGray">${addrs.recmobile}</span></p>
                    <p>${addrs.province} ${addrs.city} ${addrs.county}${addrs.detailaddrs}</p>
                </div>
                <div class="weui_cell_ft"></div>
            </a>
        </div>
    </c:if>

    <c:if test="${null == addrs}">
        <div class="weui_cells weui_cells_access">
            <a class="weui_cell" href="<%=bp%>/addrs/myAddrList">
                <div class="weui_cell_hd"><i class="iconfont icon-address mr5"></i></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <p>选择收获地址</p>
                </div>
                <div class="weui_cell_ft"></div>
            </a>
        </div>
    </c:if>

    <h1 class="tc title mt10 mb10">商品详情</h1>
    <div class="p10 bgwh pb0">
        <ul class="newsList">
            <c:if test="${null == mycart}">
                购物车没有记录~
            </c:if>
            <c:if test="${null != mycart}">
                <c:forEach var="cart" items="${mycart}">
                    <c:set var="total" scope="page" value="${total+cart.get('price')/100 * cart.get('amount')}"/>
                    <li>
                        <a href="<%=bp%>/goods/detail/${cart.get('goodsId')}" class="newsListImg"><img
                                src="<%=bp%>${cart.get('imgs')}" alt="">
                        </a>
                        <div class="pl10 ovh">
                            <a href="<%=bp%>/goods/detail/${cart.get('goodsId')}"
                               class="title">${cart.get("name")}</a>
                            <p><b class="cr">￥${cart.get('price') / 100 }</b></p>
                            <p class="pro pl0 tr">
                                <i class="min"
                                   onclick="javascript:minnum(${cart.get('cartId')},${cart.get('price')/100});"></i>
                                <input type="text" value="${cart.get('amount')}" size="4" class="tc h33" id="text${cart.get('cartId')}"
                                       readonly="readonly">
                                <i class="add"
                                   onclick="javascript:addnum(${cart.get('cartId')},${cart.get('price')/100});"></i>
                            </p>
                        </div>
                    </li>

                </c:forEach>
            </c:if>
        </ul>
    </div>
    <div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <textarea class="weui_textarea" placeholder="给卖家留言"></textarea>
            </div>
        </div>
    </div>
    <%-- <div class="weui_cells weui_cells_access"><a class="weui_cell" href="代金券.html">
         <div class="weui_cell_hd"><i class="iconfont icon-quan mr5"></i></div>
         <div class="weui_cell_bd weui_cell_primary">
             <p>代金券</p>
         </div>
         <div class="weui_cell_ft">有<span class="cr b ml5 mr5">2</span>张可用</div>
     </a></div>--%>

    <div class="tr p15">
        <p class="f12 mb5">运费：<span class="cr fa">¥0.00</span></p>
        <p class="">应付金额：<span class="cr fa b">¥ <span id="totalprice">${total}</span>  </span></p>
    </div>
    <div class="plr15 pb30">
        <a class="weui_btn weui_btn_primary bgg" href="javascript:push();">
            提交订单</a>
    </div>

</div>


<script>

    /*   wx.chooseWXPay({
     timestamp: 0, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
     nonceStr: '', // 支付签名随机串，不长于 32 位
     package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
     signType: '', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
     paySign: '', // 支付签名
     success: function (res) {
     // 支付成功后的回调函数
     }
     });*/

</script>

<script type="text/javascript">

    function push() {
       window.location.href ="<%=bp%>/order/createOrder/${addrs.id}?param="+$("#totalprice").html();
    }
    
    
    function minnum(num, prince) {
        if (parseInt($("#text" + num).val()) <= 1) {
            alert("不能再少了！");
            return;
        }
        $("#text" + num).val($("#text" + num).val() - 1);
        $("#totalprice").html($("#totalprice").html() - prince);
        $.get("<%=bp%>/cart/minAmount",{cartId:num});
    }

    function addnum(num, prince) {
        if (num > 100) {
            alert("超过最大值");
            return;
        }
        $("#text" + num).val(parseFloat($("#text" + num).val()) + 1);
        $("#totalprice").html(parseFloat($("#totalprice").html()) + prince);
        $.get("<%=bp%>/cart/addAmount",{cartId:num});
    }
</script>


<%--引入footer.jsp--%>
<%@ include file="/plugjsp/footer.jsp" %>


</body>
</html>
