<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/6/10 16:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>

<html>
<head>
    <title>用户地址列表</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>


<div class="header"><a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <a href="javascript:save();" class="hdBtn">保存默认地址</a>
    <h1>我的地址</h1>
</div>

<div class="content js_container bgef">

    <c:if test="${null != addList}">
        <div class="weui_cells weui_cells_radio">
            <c:forEach items="${addList}" var="addr">
                <label class="weui_cell weui_check_label fln" for="${addr.id}">
                        ${addr.recname}<span class="p5"></span>${addr.recmobile}<br>
                        ${addr.province} ${addr.city} ${addr.county}<span class="p5"></span>${addr.detailaddrs}
                    <div class="weui_cell_ft fr">
                        <input type="radio" class="weui_check" name="radio1" id="${addr.id}" value="${addr.id}"
                        <c:if test="${true == addr.isdefault}"> checked="checked" </c:if> >
                        <span class="weui_icon_checked"></span>
                    </div>
                </label>

            </c:forEach>
        </div>

    </c:if>

    <div class="weui_cells weui_cells_access">
        <a class="weui_cell" href="<%=bp%>/addrs/toaddrs">
            <div class="weui_cell_bd weui_cell_primary">
                <p><i class="iconfont icon-jiahao1 mr5"> </i>新增收货地址</p>
            </div>
        </a>
    </div>
</div>


<script>
    function save() {
        var val = $('input[name="radio1"]:checked').val();
        window.location.href="<%=bp%>/addrs/upAddrDef?id="+val;
    }

</script>

</body>
</html>
