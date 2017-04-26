<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/3/20 22:31
--%>
<%--用来引用一些公用的文件--%>

<%  //这里可以删除一些文件，因为并不是所有的都需要引用，引用太多降低速度  %>

<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
--%>
<!-- 微信UI -->
<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css"/>
<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.1/weui.css"/>

<%
    //获取 根路径，主要是对资源来说的
    String path = request.getContextPath();
    String bp = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<%--<%=bp %>--%>

<!-- 微信浏览器缓存解决 -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="keywords" content="">
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<%--引入其他文件--%>
<script type="text/javascript" src="<%=bp%>/js/jquery3/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

