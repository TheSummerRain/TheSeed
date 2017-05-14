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
            callback: function(pos) {
                var i = bullets.length;
                while (i--) {
                    bullets[i].className = ' ';
                }
                bullets[pos].className = 'on';
            }
        });
        var bullets = document.getElementById('position').getElementsByTagName('li');
        $(".toggle").click(function(){
            $(this).toggleClass("sel");
            $("#zys").toggle();
            vh=$(".nav").height()+64;
            if($(".nav").is(":visible")==false){
                $("#content").css("margin-top","54px");}else{$("#content").css("margin-top",vh);}
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


<%--
<div class="userTop"><a href="#" class="closeBtn"><i class="iconfont icon-close"></i></a>
    <div class="plr15">
        <div class="userImg"><img src="<%=bp%>/images/user.jpg" alt=""></div>
        <div class="pl10 ovh fl mt15">
            <h1 class="title cwh">来自<span class="cgr mLR5">小曹</span>的推荐</h1>
            <h2 class="title cwh">立即关注，狂赚佣金</h2>
        </div>
        <div class="pl10 ovh fr mt20">
            <a href="#" class="fr weui_btn weui_btn_primary weui_btn_mini">点击关注</a>
        </div>
    </div>
    <script>
        $(function (){
            $(".closeBtn").click(function(){
                $(".userTop").toggle();})
        })
    </script>
</div>
--%>

<div class="content js_container mt0">
    <div class="topImg bgwh">
        <div id="slider" class="swipe" style="visibility: visible;">
            <div class="swipe-wrap">
                <figure>
                    <div class="wrap"> <a href="#"><img src="<%=bp%>/images/news/u236.jpg" alt="" class="pct100"></a> </div>
                </figure>
                <figure>
                    <div class="wrap"> <a href="#"><img src="<%=bp%>/images/news/u237.jpg" alt="" class="pct100"></a> </div>
                </figure>
                <figure>
                    <div class="wrap"> <a href="#"><img src="<%=bp%>/images/news/u238.jpg" alt="" class="pct100"></a> </div>
                </figure>
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
    <!--产品分类-->
    <div class="rel bgwh"><a href="我的微店.html" class="logo"><img src="<%=bp%>/images/erwm.jpg" alt=""></a>
        <nav class="navItem bgb"><a href="品牌介绍.html"><i class="iconfont icon-icon4"></i><span>品牌介绍</span></a><a href="购物车.html"><i class="iconfont icon-goumai"></i><span>购物车</span></a><a href="会员中心.html"><i class="iconfont icon-zhanghao"></i><span>会员中心</span></a><a href="javascript:void(0)" class="toggle"><i class="iconfont icon-caidan"></i><span>所有商品</span></a></nav>
    </div>
    <div  class="note"><i class="iconfont mr5 icon-comiisgonggao"></i><div class="diib">这是促销信息就疯，狂的就疯狂大家分叫快递费就。</div></div>
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
    <!--产品分类结束-->
    <h2 class="title proTitle">将开发的接口附件的开发的看<a href="产品列表.html" class="more r20">更多>></a></h2>
    <ul class="proList">
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">泰济生生物治疗套餐泰济生生物治疗套餐， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
    </ul>
    <h2 class="title proTitle mt15">刀剑私服粮食店街<a href="产品列表.html" class="more r20">更多>></a></h2>
    <ul class="proList">
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
    </ul>
    <h2 class="title proTitle mt15">袋鼠杰克法律手段金连科<a href="产品列表.html" class="more r20">更多>></a></h2>
    <ul class="proList">
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
        <li><a href="产品详细.html" class="newsListImg"><img src="<%=bp%>/images/ab5.jpg" alt="">
            <h1 class="title">风纪扣的所将拉风的拉萨解放路的发快递所将垃圾费零距离， 健康的就疯狂圣诞节快，范德萨范德萨，范德萨范德萨发的撒。</h1>
            <p class="fa">价格：<span class="cr b">￥1600.00</span></p>
            <p class="cg fa">已售：1722 笔</p>
        </a> </li>
    </ul>
</div>

<footer class="footer inline-box">
    <a href="我的微店.html" class="inline_four active">
        <p><i class="iconfont icon-dianpu f20"></i></p>
        <p>我的微店</p>
    </a>

    <a href="搜索.html" class="inline_four">
        <p><i class="iconfont icon-search f20"></i></p>
        <p>搜索</p>
    </a>

    <a href="微店管理.html" class="inline_four">
        <p><i class="iconfont icon-woguanlidedianpu f20"></i></p>
        <p>微店管理</p>
    </a>

    <a href="会员中心.html" class="inline_four">
        <p><i class="iconfont icon-zhanghao1 f20"></i></p>
        <p>会员中心</p>
    </a>

</footer>

<script src="<%=bp%>/css/js/js.js"></script>
<script src="<%=bp%>/css/fastclick.js"></script>
<script>
    FastClick.attach(document.body);
</script>


</body>
</html>
