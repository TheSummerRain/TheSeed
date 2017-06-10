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
</head>
<body>




<div class="header"><%----%>
    <a href="javascript:save();" class="hdBtn">保存</a>
    <a href="javascript:history.go(-1)" class="iconfont back" style="left:0"></a>
    <h1>填加地址</h1>
</div>

<div class="content js_container bgef">
    <div class="weui_cells">
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">姓名</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="username" name="username" class="weui_input" type="text" value="" placeholder="输入真实姓名" maxlength="25">
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">手机</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="mobile" name="mobile" class="weui_input" type="text" value="" placeholder="输入手机号" maxlength="11">
            </div>
        </div>
    </div>
    <div class="weui_cells_title">收货地址</div>
    <div class="weui_cells">
        <div class="weui_cell weui_cell_select weui_select_after">
            <div class="weui_cell_hd">
                省
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <select class="weui_select" name="select1">
                    <option selected="" value="1">河南省</option>
                </select>
            </div>
        </div>
        <div class="weui_cell weui_cell_select weui_select_after">
            <div class="weui_cell_hd">
                市
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <select class="weui_select" name="select1">
                    <option selected="" value="1">安阳市</option>
                </select>
            </div>
        </div>
        <div class="weui_cell weui_cell_select weui_select_after">
            <div class="weui_cell_hd">
                区/县
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <select class="weui_select" name="select2">
                    <option value="1">林州市</option>
                </select>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd">
                <label for="" class="weui_label">详细</label>
            </div>
            <div class="weui_cell_bd weui_cell_primary">
                <input id="xiangxi" name="xiangxi" class="weui_input" type="text" value="" placeholder="输入详细地址" maxlength="100">
            </div>
        </div>
    </div>
</div>

<script>
function save() {
    var username = $("#username").val();
    if(username.length==0){
        alert("姓名不能为空");
        return;
    }
    var mobile =$("#mobile").val();
    if(mobile.length==0){
        alert("请填写一个正确的手机号");
        return;
    }
    var xiangxi = $("#xiangxi").val();
    if(xiangxi.length==0){
        alert("请填写详细地址");
        return;
    }

    window.location.href = "<%=bp%>/addrs/istAddr?username="+username+"&mobile="+mobile+"&xiangxi="+xiangxi;
   // $.post("<%=bp%>/addrs/istAddr",{username:username,mobile:mobile,xiangxi:xiangxi});
}


</script>

</body>
</html>
