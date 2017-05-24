<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/5/14 16:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<script src="<%=bp%>/css/js/swipe.js"></script>

<script>
    $(function () {
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
        $(".toggle").click(function () {
            $(this).toggleClass("sel");
            $("#zys").toggle();
            vh = $(".nav").height() + 64;
            if ($(".nav").is(":visible") == false) {
                $("#content").css("margin-top", "54px");
            } else {
                $("#content").css("margin-top", vh);
            }
        })
    });
</script>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>


<div class="content js_container mt0">

    <!-- banner 区域 -->
    <div class="topImg bgwh">
        <div id="slider" class="swipe" style="visibility: visible;">
            <div class="swipe-wrap">

                <c:forEach items="${baner}" var="ba">
                    <figure>
                        <div class="wrap"><a href="#"><img src="<%=bp%>${ba.bimgurl}" alt="" class="pct100"></a>
                        </div>
                    </figure>
                </c:forEach>
            </div>
        </div>
        <nav>
            <ul id="position" style="position: absolute;z-index: 1;top: -20px;left: 50%;margin-left: -23px;">
                <li class="on"></li>
                <li class=""></li>
                <li class=""></li>
            </ul>
        </nav>
    </div>

    <!--产品分类，可隐藏 -->
    <div class="rel bgwh">
        <a href="#" class="logo"><img src="<%=bp%>/images/erwm.jpg" alt=""></a>
        <nav class="navItem bgb">
            <a href="品牌介绍.html"><i class="iconfont icon-icon4"></i><span>品牌介绍</span></a>
            <a href="购物车.html"><i class="iconfont icon-goumai"></i><span>购物车</span></a>
            <a href="会员中心.html"><i class="iconfont icon-zhanghao"></i><span>会员中心</span></a>
            <a href="javascript:void(0)" class="toggle"><i class="iconfont icon-caidan"></i><span>所有商品</span></a>
        </nav>
    </div>

    <!-- 日志公告 可隐藏 -->
    <div class="note"><i class="iconfont mr5 icon-comiisgonggao"></i>
        <div class="diib">一些重要公告说明，可以写一句话放这里</div>
    </div>

    <!-- 产品列表，可隐藏 -->
    <div class="itemList" id="zys" style="display:none">
        <ul>
            <li class="pct30"><a href="产品列表.html">产品发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">产品分发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">产分类发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">分类发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">品分类发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">分类发发接口的</a></li>
            <li class="pct30"><a href="产品列表.html">产品发发接口的</a></li>
        </ul>
    </div>

    <!-- 主内容区域 -->
    <h2 class="title proTitle">车载电器<a href="<%=bp%>/home/sort/1" class="more r20">更多>></a></h2>
    <ul class="proList">
        <c:forEach var="g1" items="${gods1}">
            <li><a href="<%=bp%>/goods/detail/${g1.gdid}" class="newsListImg"><img src="<%=bp%>${g1.imgs}" alt="">
                <h1 class="title">${g1.name}</h1>
                <p class="fa">价格：<span class="cr b">￥${g1.price/100}</span></p>
                <p class="cg fa">已售：${g1.virtualsales} 笔</p></a>
            </li>
        </c:forEach>
    </ul>


    <h2 class="title proTitle">汽车装饰<a href="<%=bp%>/home/sort/2" class="more r20">更多>></a></h2>
    <ul class="proList">
        <c:forEach var="g2" items="${gods2}">
            <li><a href="<%=bp%>/goods/detail/${g2.gdid}" class="newsListImg"><img src="<%=bp%>${g2.imgs}" alt="">
                <h1 class="title">${g2.name}</h1>
                <p class="fa">价格：<span class="cr b">￥${g2.price/100}</span></p>
                <p class="cg fa">已售：${g2.virtualsales} 笔</p></a>
            </li>
        </c:forEach>
    </ul>

    <h2 class="title proTitle">美容清洗<a href="<%=bp%>/home/sort/3" class="more r20">更多>></a></h2>
    <ul class="proList">
        <c:forEach var="g3" items="${gods3}">
            <li><a href="<%=bp%>/goods/detail/${g3.gdid}" class="newsListImg"><img src="<%=bp%>${g3.imgs}" alt="">
                <h1 class="title">${g3.name}</h1>
                <p class="fa">价格：<span class="cr b">￥${g3.price / 100}</span></p>
                <p class="cg fa">已售：${g3.virtualsales} 笔</p></a>
            </li>
        </c:forEach>
    </ul>


</div>

<%--引入footer.jsp--%>
<%@ include file="/plugjsp/footer.jsp" %>


</body>
</html>
