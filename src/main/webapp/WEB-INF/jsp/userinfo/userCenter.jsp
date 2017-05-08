<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/3/17 22:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- 日期使用引用 -->--%>
<html>
<head>
    <title>用户中心</title>
</head>
<body>

生日：${userInfo.birth}<br>
openid:${userInfo.wxOpenid}<br>
微信昵称：${userInfo.wxNickName}<br>
头像：<img src="${userInfo.wxHeadimgurl}">


<%--
<!-- 日期使用例子 -->
<fmt:formatDate value="${userInfo.birth}" pattern="yyyy-MM-dd"/>
--%>

手机号：${userInfo.mobile}<br>

昵称：${userInfo.nickName}<br>
ID:${userInfo.userid}<br>

</body>
</html>
