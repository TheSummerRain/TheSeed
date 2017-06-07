<%--
  Created by IntelliJ IDEA.
  Author: JACK
  Date: 2017/6/7 21:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/plugjsp/header.jsp" %>

<html>
<head>
    <title>地址管理</title>
    <link rel="stylesheet" href="<%=bp%>/css/common.css">
    <link rel="stylesheet" href="<%=bp%>/css/main.css">
    <script src="http://libs.baidu.com/html5shiv/3.7/html5shiv.min.js"></script>
</head>
<body>




<div class="header">
    <a href="地址.html" class="hdBtn">保存</a><a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <h1>填加地址</h1>
</div>

<div class="content js_container bgef">
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="text" value="" placeholder="输入真实姓名">
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">手机</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="text" value="" placeholder="输入手机号">
            </div>
        </div>
    </div>
    <div class="weui_cells_title">收货地址:这里可以把省市区固定死，不支持安阳市外的。</div>

    <div class="weui_cells">


        <div class="jq22-container">
            <form class="form-inline">
                <div data-toggle="distpicker">
                    <div class="form-group">
                        <label class="sr-only" for="province3">选择省：</label>
                        <select class="form-control" id="province3" data-province="河南省"></select>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="city3">选择市：</label>
                        <select class="form-control" id="city3" data-city="安阳市"></select>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="district3">选择县、区：</label>
                        <select class="form-control" id="district3" data-district="林州市"></select>
                    </div>
                </div>
            </form>
        </div>


        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">详细</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="text" value="" placeholder="输入详细地址">
            </div>
        </div>
    </div>

</div>





<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script src="<%=bp%>/js/addrplus/distpicker.data.js"></script>
<script src="<%=bp%>/js/addrplus/distpicker.js"></script>
<script src="<%=bp%>/js/addrplus/main.js"></script>
</body>
</html>
