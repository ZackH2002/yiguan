<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/15
  Time: 11:09
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
  <link rel="stylesheet" href="../css/table_in.css" rel="external nofollow" />
  <script>
    function deleteInfo(val) {
      const r = confirm('确定删除此信息？')
      if (r === true) {

        window.location.replace("/DepositoryServlet?caozuo=deleteIn&id="+val);

      }
      return false
    }
  </script>
</head>
<body>
<div>
  <header>
    <hr />
    <h1>入库</h1>
    <hr />
  </header>
  <main>
    <div>
      <div id="adbt">
        <a class="xiu" href="add.jsp">增加记录</a>
        <a class="dele" href="studentServlet?caozuo=exit">退出系统</a>
      </div>
      <div class="table1">
        <table>
          <tbody>
          <tr id="thead">
            <td>ID</td>
            <td>材料名称</td>
            <td>仓库名称</td>
            <td>数量</td>
            <td>金额</td>
            <td>操作员</td>
            <td>操作时间</td>
            <td>操作</td>
          </tr>
          <c:forEach var="record" items="${sessionScope.listIn}">
            <tr>
            <td>${record.id}</td>
            <td>${record.materialName}</td>
            <td>${record.depositoryName}</td>
            <td>${record.quantity}</td>
            <td>${record.price}</td>
            <td>${record.applicantName}</td>
            <td>${record.applyTime}</td>
            <td>
<%--              <a class="dele" href="javascript:;" onclick="deleteInfo(${record.id})>删除</a>--%>
                  <a class="dele" href="javascript:;" onclick="deleteInfo(${record.id})">删除</a>
            </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </main>
</div>
</body>
</html>
