<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/5/24 16:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<html>
<head>
    <title>商品分类</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>

<div class="header"><a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <a href="<%=bp%>/home/shouye"
       class="iconfont shopHome"
       style="right: 45px;border-right: 1px #93C8F0 solid;"></a><a
            href="购物车.html" class="iconfont shopCart" style="right:0"><span class="shopCartLabel">3</span></a>
    <h1>${ListName}</h1>
</div>
<div class="content js_container">
    <ul class="proList">

        <c:forEach var="gd" items="${goodslst}">
            <li><a href="<%=bp%>/goods/detail/${gd.gdid}" class="newsListImg"><img src="<%=bp%>${gd.imgs}" alt="">
                <h1 class="title">${gd.name}</h1>
                <p class="fa">价格：<span class="cr b">￥${gd.price / 100}</span></p>
                <p class="cg fa">已售：${gd.virtualsales} 笔</p>
            </a></li>
        </c:forEach>

    </ul>

</div>


<%--引入footer.jsp--%>
<%@ include file="/plugjsp/footer.jsp" %>

</body>
</html>
