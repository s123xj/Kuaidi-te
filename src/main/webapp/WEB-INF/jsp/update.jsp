
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("img/1.png");
            background-size: cover;
        }

        #container{
            background-color:skyblue;
            color:orange;
            padding:15px;
            margin: 100px auto 0px;
            width:600px;
            text-align:center;
            font-family:"微软雅黑 Light";
            box-shadow: 10px 10px 15px black;
        }

        hr{
            width:80%;
            border:orange 1px solid;
            margin-bottom:15px;
        }

        input{
            width:180px;
            height:20px;
            margin:5px;
            font-size:16px;
            font-family:"微软雅黑 Light";
        }

        button{
            width:120px;
            height:40px;
            background-color:orange;
            border:0px;
            color: white;
            margin:10px;
            font-size:18px;
            font-family:"微软雅黑 Light";
            font-weight:bold;
        }

        button:hover{
            background-color:orange;
        }

    </style>
</head>
<body>
<center>

</center>
<div id="container" align="center">
    <h1 >修改信息</h1>
    <form action="/require" method="post">
        <c:forEach items="${tf}" var="tfom">
<%--            国家id:<input type="text" name="id" value="${tfom.id}"><br>--%>
<%--            国家编号:<input type="text" name="id" value="${tfom.id}"><br>--%>
            国家名称:<input type="text" name="infom" value="${tfom.infom }"><br>
            初始票数:<input type="text" name="pnumber"value="${tfom.pnumber}"><br>
<%--            ${tfom.id}--%>
            <button  type="submit" name="id" value="${tfom.id}">提交</button>
        </c:forEach>

    </form>


</div>


</body>
</html>
