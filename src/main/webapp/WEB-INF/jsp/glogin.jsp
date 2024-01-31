
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        body{
            background-image: url("img/2.png");
            background-size: cover;
        }
        .h3{
            text-align:center;
            font-family:"微软雅黑 Light";

        }
        input{
            width:180px;
            height:22px;
            margin:12px;
            font-size:16px;
            font-family:"微软雅黑 Light";
        }
        .h2{
            margin-top: 100px;
            color: skyblue;
        }

        .submit{
            height: 40px;
            width: 80px;
            font-weight: bold;
            font-size: 18px;
            background-color:skyblue;
            border-radius: 100px;
            margin: 5px auto;
            margin-left: 100px;

        }

    </style>
</head>
<body>

<form action="/gtest" method="post">
    <div class="h3" >
        <h1 class="h2">欢迎管理员登入</h1>
        账号:<input type="text" name="username"><br>
        密码:<input type="text" name="password"><br>
        <input type="submit" value="登入" class="submit">
        <input type="reset" value="重置" class="submit">
        <a href="${pageContext.request.contextPath}/static/gzhuce.jsp">账号注册</a>
    </div>
</form>
</body>
</html>
