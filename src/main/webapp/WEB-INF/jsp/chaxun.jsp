
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-size: cover;
        }

        .h3{
            background-color:skyblue;
            padding:100px;
            margin: 20px auto 0px;
            width:600px;
            text-align:center;
            font-family:"微软雅黑 Light";
        }

    </style>
</head>
<body>
<center>
    <h1>票数详细信息</h1>
</center>
<div class="h3" align="center">
        <c:forEach items="${tf}" var="tfom">
            <table border="1" cellspacing="5"align="center">
                <tr>
                    <th width="100px">国家名称</th>
                    <th width="100px">支持票数</th>
                </tr>
                <tr>
                    <td align="center" width="100px">${tfom.infom }</td>
                    <td align="center" width="100px">${tfom.pnumber}</td>
                </tr>
            </table>
        </c:forEach>
    <button><h2><a href="${pageContext.request.contextPath}/caidan">返回菜单</a></h2></button>


</div>


</body>
</html>
