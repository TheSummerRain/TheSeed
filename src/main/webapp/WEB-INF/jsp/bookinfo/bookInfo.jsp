<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 2017/3/17
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/plugjsp/header.jsp" %>
<script src="<%=bp%>/js/test.js" type="text/javascript" >
</script>
<html>
<head>
    <title>显示书籍信息</title>
</head>
<body>
<br>
${bookInfo.bid}
<br>
${bookInfo.title}

===============
<button id="abc" type="button" onclick="ceshi(123)">按钮</button>

<img id="img1" src="<%=bp %>/img/50.jpg">

</body>

<script>

    $(function () {
        alert("kkkkkkkk");


    $("#img1").click(function () {
        alert("图片");
    });



    });
    
</script>


</html>
