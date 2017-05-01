<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 2017/3/17
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
    <%@ include file="/plugjsp/header.jsp" %>
    <script src="<%=bp%>/js/test.js" type="text/javascript" ></script>

    <title>显示书籍信息</title>
</head>
<body>

<a href="javascript:;" class="weui-btn weui-btn_primary">页面主操作 Normal</a>
<a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_primary">页面主操作 Disabled</a>
<a href="javascript:;" class="weui-btn weui-btn_default">页面次要操作 Normal</a>
<a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_default">页面次要操作 Disabled</a>
<a href="javascript:;" class="weui-btn weui-btn_warn">警告类操作 Normal</a>
<a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_warn">警告类操作 Disabled</a>


<br>
${bookInfo.bid}
<br>
${bookInfo.title}

<img id="img1" src="<%=bp %>/img/50.jpg">

</body>

</html>
