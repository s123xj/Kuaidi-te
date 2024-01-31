
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

        .h3{
            background-color:skyblue;
            padding:100px;
            margin: 20px auto 0px;
            width:600px;
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
<center>
    <h1>增加投票记录</h1>
</center>
<form action="/adinfrom" method="post">
    <div class="h3" align="center">
    <label>国家名称：<input type="text" name="infom"></label><br>
    <label>初始票数：<input type="text" name="pnumber"></label><br>
    <input type="submit" value="确认"class="submit">
    <input type="reset" value="重置"class="submit">
    </div>

</form>



</body>
</html>
