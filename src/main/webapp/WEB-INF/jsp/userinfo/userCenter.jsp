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

生日：${userInfo.birth}

<%--
<!-- 日期使用例子 -->
<fmt:formatDate value="${userInfo.birth}" pattern="yyyy-MM-dd"/>
--%>

手机号：${userInfo.mobile}

昵称：${userInfo.nickName}
ID:${userInfo.userid}

</body>
</html>
