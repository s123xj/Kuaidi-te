
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户信息</title>
    <style type="text/css">
        body{
            background-image: url("img/2.png");
            background-size: cover;
        }

        .h3{
            background-color:skyblue;
            padding:100px;
            margin: 20px auto 0px;
            width:400px;
            text-align:center;
            font-family:"微软雅黑 Light";
        }
        .submit{
            height: 40px;
            width: 80px;
            font-weight: bold;
            font-size: 18px;
            background-color:orange;
            border-radius: 100px;
            margin: 5px auto;
            margin-left: 15px;

        }

    </style>
</head>
<body>
<center>
    <h1>用户详细信息</h1>
</center>
<div class="h3" align="center">
        <c:forEach items="${tf}" var="tfom">
            <table border="1" cellspacing="5"align="center">
                <tr>
                    <th width="100px">用户名</th>
                    <th width="100px">密码</th>
                </tr>
                <tr>
                    <td align="center" width="100px">${tfom.username}</td>
                    <td align="center" width="100px">${tfom.password}</td>
                </tr>
            </table>

        </c:forEach>
        <button><h2><a href="${pageContext.request.contextPath}/gcaidan">返回菜单</a></h2></button>

</div>


</body>
</html>
