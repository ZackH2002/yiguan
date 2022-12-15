<%@ page import="java.util.List" %>
<%@ page import="com.yiguan.model.vo.DepositoryStockVO" %><%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2022/12/15
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    List<DepositoryStockVO> data = (List<DepositoryStockVO>) request.getAttribute("data");


%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/table_in.css" rel="external nofollow" />
    <script>
        function deleteInfo(val) {
            const r = confirm('确定删除此信息？')
            if (r === true) {

                window.location.replace("DepositoryServlet?caozuo=delete&id="+val);

            }
            return false
        }
    </script>
</head>
<body>
<div>
    <header>
        <hr />
        <h1>库存</h1>
        <hr />
    </header>
    <main>
        <div>
            <div id="adbt">
                <a class="dele" href="studentServlet?caozuo=exit">退出系统</a>
            </div>
            <div class="table1">
                <table>
                    <tbody>
                    <tr id="thead">
                        <td>材料名称</td>
                        <td>仓库名称</td>
                        <td>数量</td>
                        <td>金额</td>
                    </tr>
                    <c:forEach var="record" items="${requestScope.data}">
                        <tr>
                            <td>${record.materialName}</td>
                            <td>${record.name}</td>
                            <td>${record.stock}</td>
                            <td>${record.price}</td>
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

