
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
    <h1>谁是您心目中的冠军</h1>
</center>
<div class="h3" align="center">
    <form action="/adpiao" method="post">
        <c:forEach items="${tf}" var="tfom">
            <tr>
                <label><h6>${tfom.infom}</h6><input type="radio" name="id" value="${tfom.id}"></label><br>
            </tr>

        </c:forEach>

        <input type="submit" value="投票" class="submit">
    </form>


</div>


</body>
</html>
