<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/15
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% // 判断session中不存在登录的时候放入的用户实例，则认为处于非登录状态
  if(session.getAttribute("user")==null){
    response.sendRedirect("login.htm");
  }
%>
<html>
<head>
  <title>Title</title>
</head>
<style>
  html {
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
  body {
    width: 100%;
    height: 100%;
    font-family: 'Open Sans', sans-serif;
    margin: 0;
    /*background-color: #4A374A;   */
    background-color: #f0ece9;
  }
  #addform {
    position: absolute;
    top: 20%;
    left: 40%;
    margin: -150px 0 0 -150px;
    width: 500px;
    height: 500px;
    background-color: white;
  }
  #addform h1 {
    color: #fff;
    letter-spacing: 1px;
    text-align: center;
  }
  .inputtext {
    width: 278px;
    height: 18px;
    margin-bottom: 10px;
    outline: none;
    padding: 20px;
    font-size: 13px;
    color: #fff;
    border-top: 1px solid #00be98;
    border-left: 1px solid #00be98;
    border-right: 1px solid #00be98;
    border-bottom: 1px solid #00be98;
    border-radius: 4px;
    background-color: #1abc9c;
  }
  select {
    border: none;
    color: #fff;
    background-color: #1abc9c;
    margin-top: 10px;
    width: 278px;
    padding: 10px;
    height: 40px;
  }
  option:hover {
    background: #146551;
  }
  .btn {
    width: 100px;
    min-height: 40px;
    /*display: block;   */
    display: inline-block;
    background-color: #1abc9c;
    /*border: 1px solid #8a9897;*/
    border: 1px solid #60d8ba;
    color: #fff;
    padding: 9px 14px;
    font-size: 15px;
    line-height: normal;
    border-radius: 5px;
    margin: 20px 5px;
  }
</style>
<body>
<div id="addform">
  <h1>新增出库信息</h1>
  <form
          action="/DepositoryServlet?caozuo=out"
          method="post"
  >
    <table align="center">
      <tr>
        <td>材料名称</td>
        <td>
          <input type="text" name="name" class="inputtext" />
        </td>
      </tr>
      <tr>
        <td>数量</td>
        <td>
          <input type="text" name="quantity" class="inputtext" />
        </td>
      </tr>
      <tr>
        <td>出库金额</td>
        <td>
          <input type="text" name="price" class="inputtext" />
        </td>
      </tr>
      <tr>
        <td>仓库</td>
        <td>
          <select class="select" name="depositoryId">
            <option value="1">童装</option>
            <option value="2">男装</option>
            <option value="3">女装</option>
            <option value="4">玩具</option>
            <option value="5">文具</option>
          </select>
        </td>
      </tr>
      <tr align="center">
        <td>
          <input type="submit" value="新增" class="btn" />
        </td>
        <td>
          <input type="reset" value="重置" class="btn" />
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>