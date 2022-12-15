<%@ page import="com.yiguan.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: hyc
  Date: 2022/12/15
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>个人信息</title>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <link rel="stylesheet" href="/css/info.css" />
</head>
<body>
<%
  User user = (User) request.getSession().getAttribute("user");
  int gender = user.getGender();
  int userAuth = user.getUserAuth();
  String userPassword = user.getUserPassword();

%>
<div class="content">
  <p>个人信息:</p>
  <div class="col1">
    <span class="title">姓名:</span><span><%=user.getUserName()%></span>
    <span class="title">性别:</span><span><%=gender == 0 ? '男' : '女'%></span>
  </div>
  <div class="col2">
    <span class="title">电话:</span><span><%=user.getPhone()%></span>
    <span class="title">权限:</span><span><%=userAuth == 0 ? "超级管理员" : "员工"%></span>
  </div>
  <div class="col3">
    <span class="title">入职时间:</span><span><%=user.getEntryDate()%></span>
    <span class="title">密码:</span
    ><span id="password">********</span>
  </div>
</div>


</body>
</html>
