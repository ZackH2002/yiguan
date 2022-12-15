<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/14
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css" />
    <script type="text/javascript" src="../js/login.js"></script>
</head>
<body>
<div class="login">
    <div class="box">
        <p class="table">Login</p>
        <form name="login_from" action=login method="post">
            <br />
            <input type="text" name="username" placeholder="账号" />
            <input type="password" name="password" placeholder="密码" />
            <br />
            <button class="btn" type="submit">
                登录
            </button>
        </form>

        <!-- <a href="#" class="go">GO</a> -->
    </div>
</div>
</body>
</html>
