<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/5/28 15:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>
<html>
<head>
    <title>搜索</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
</head>
<body>


<div class="header"><a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <h1>搜索</h1>
</div>

<div class="content js_container bgef">
    <div class="weui_cells weui_cells_access">
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">搜索</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="text" placeholder="请输入查询关键字">
            </div>
        </div>
    </div>
    <div class="weui_cells weui_cells_access"> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> <a class="weui_cell" href="产品列表.html">
        <div class="weui_cell_hd"><i class="iconfont icon-dianpu mr5 cbl"></i></div>
        <div class="weui_cell_bd weui_cell_primary">
            <p>产品分类1</p>
        </div>
        <div class="weui_cell_ft"></div>
    </a> </div>
</div>

<%--引入footer.jsp--%>
<%@ include file="/plugjsp/footer.jsp" %>


</body>
</html>
