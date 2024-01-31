
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-image: url("img/2.png");
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
<%--    tfom 自己取得 随便取--%>
    <c:forEach items="${tf}" var="tfom">
        <table border="1" cellspacing="5"align="center">
            <tr>
                <th width="100px">国家名称</th>
                <th width="100px">支持票数</th>
                <th width="100px">删除记录</th>
                <th width="100px">修改记录</th>

            </tr>
            <tr>
                <td align="center" width="100px">${tfom.infom }</td>
                <td align="center" width="100px">${tfom.pnumber}</td>
                <td align="center" width="100px"><a href="${pageContext.request.contextPath}/deleinform?id=${tfom.id}">删除</a></td>
                <td align="center" width="100px"><a href="${pageContext.request.contextPath}/requinfom?id=${tfom.id}">修改</a></td>
            </tr>
        </table>
    </c:forEach>
    <button><h2><a href="${pageContext.request.contextPath}/alueser">查看用户</a></h2></button>
    <button><h2><a href="${pageContext.request.contextPath}/adinformjsp">增加信息</a></h2></button>
    <button><h2><a href="${pageContext.request.contextPath}/index">退出登入</a></h2></button>



</div>


</body>
</html>
