<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/5/24 17:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<script src="<%=bp%>/css/js/swipe.js"></script>
<html>
<head>
    <script>
        $(function () {
            /*$("#share").click(function () {
             $("body").append("<div class='maskA'><div><img src='
            <%=bp%>/css/images/jiantou.png' height='170'></div></div>");
             $(".maskA").click(function () {
             $(".maskA").remove();
             })
             });*/
            var slider = Swipe(document.getElementById('slider'), {
                auto: 3000,
                continuous: true,
                callback: function (pos) {
                    var i = bullets.length;
                    while (i--) {
                        bullets[i].className = ' ';
                    }
                    bullets[pos].className = 'on';
                }
            });
            var bullets = document.getElementById('position').getElementsByTagName('li');
            $('#view_all').easytabs();
        })

    </script>
    <title>产品详情</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>

<div class="header"><a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <a href="<%=bp%>/home/shouye"
       class="iconfont shopHome" style="right: 45px;border-right: 1px #93C8F0 solid;"></a>
    <a href="购物车.html" class="iconfont shopCart" style="right:0">
        <span class="shopCartLabel">3</span></a>
    <h1>产品详情</h1>
</div>

<div class="content js_container">
    <div class="pl10 pr10 pt10">
        <div class="bd2 pro2 ovh">
            <div class="proL topImg">
                <div id="slider" class="swipe" style="visibility: visible;">
                    <div class="swipe-wrap">
                        <c:forEach var="img" items="${goodsImgas}">
                            <figure>
                                <div class="wrap"><a class="image"><img src="<%=bp%>${img.imgurl}" alt=""></a></div>
                            </figure>
                        </c:forEach>
                    </div>
                </div>
                <nav>
                    <ul id="position" style="display:block">
                        <li class="on"></li>
                        <li class=""></li>
                        <li class=""></li>
                    </ul>
                </nav>
            </div>

            <div class="ovh proR">
                <h2 class="p0 mb20">${goods.name}</h2>
                <p class="f14 cr fa">折扣价：￥${goods.salesprice / 100} <span class="tdl ml10 cg">（￥${goods.price}元）</span>
                </p>
            </div>
            <div class="line"></div>
            <%-- <div class="p10 inline-box f0 pt0">
                 <a href="" class="abtn mr15 inline_two f16 db tc br1" id="showToast">
                     <i class="iconfont icon-dianzan mr5"></i>点赞</a>
                 <a href="javascript:void(0)" class="abtn inline_two f16 db tc" id="share">
                     <i class="iconfont icon-sponsor mr5"></i>分享</a>
             </div>--%>
        </div>
    </div>

    <%--  <div class="pl10 pr10 mt10">
          <div class="bd2 bgwh p10 inline-box f0">
              <div class="abtn inline_three f14 db tc">销量<p class="cr fa f12 mt5">291件</p></div>
              <div class="abtn mr15 inline_three f14 db tc blr1">点赞<p class="cr fa f12 mt5">2154次</p></div>
              <div class="abtn inline_three f14 db tc">分享<p class="cr fa f12 mt5">457次</p></div>
          </div>
      </div>--%>

    <div id="view_all" class="ovh p10" style="margin-bottom:35px;">
        <ul class="mt mt0">
            <li style="width:50%"><a href="#view_all_1">商品介绍</a></li>
            <li style="width:50%"><a href="#view_all_2">商品参数</a></li>
        </ul>
        <div id="view_all_1" class="bgwh p10 mb10">

            ${goodsDetail.detail}

            <%-- <p class="f0">
                 <img src="<%=bp%>/images/u34.jpg" alt="">
                 <img src="<%=bp%>/images/u39.jpg" alt="" class="pct100"><img
                     src="<%=bp%>/images/u41.jpg" alt="" class="pct100">
             </p>--%>

        </div>

        <div id="view_all_2" class="bgwh mb10 p10">

            ${goodsDetail.pramdetail}

            <%-- 泰济生医院天津总部
             泰济生医院天津万达分部卡死 沙发沙发斯蒂芬拉丝粉静安寺来犯贱阿发撒旦法撒旦发
             afasdfasdfasfasdfsdf阿斯顿发斯蒂芬
             阿斯顿发斯蒂芬
             gagfsdfsdf而对方VC额的对方反倒是饭法师打发发大水发--%>


        </div>

    </div>

</div>

<div class="footer proFooter">
    <p><span class="dib vam mtf4 pro pl0"><i class="min"></i>
    <input type="text" value="1" size="4" class="tc h33" id="">
    <i class="add"></i> <a href="daigouliucheng1.html" class="addshopCart diib pt0 cwh">购买</a>
    </span></p>
</div>

<%--<!--BEGIN toast-->
<div id="toast" style="display: none;">
    <div class="weui_mask_transparent"></div>
    <div class="weui_toast">
        <i class="weui_icon_toast"></i>
        <p class="weui_toast_content">已点赞</p>
    </div>
</div>
<!--end toast-->--%>

<script src="<%=bp%>/css/js/js.js"></script>
<script src="<%=bp%>/css/fastclick.js"></script>
<script>
    FastClick.attach(document.body);
</script>


</body>
</html>
