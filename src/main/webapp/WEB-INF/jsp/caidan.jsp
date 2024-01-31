
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-image: url("img/2.png");
            background-size: cover;
        }
        .h1{
            margin-top: 60px;
        }
        .h2{
            width: 200px;
            height: 100px;
            background-color: honeydew;
            margin-top: 40px;
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
<div  class="h1" align="center"><h1>菜单</h1></div>
<div class="h3" align="center">
    <button class="h2"><h2><a href="${pageContext.request.contextPath}/chaxun2">参与投票</a></h2></button>
    <button class="h2"><h2><a href="${pageContext.request.contextPath}/chaxun">查看票数</a></h2></button>
    <button class="h2"><h2><a href="${pageContext.request.contextPath}/index">回到主页</a></h2></button>
</div>

</body>
</html>
