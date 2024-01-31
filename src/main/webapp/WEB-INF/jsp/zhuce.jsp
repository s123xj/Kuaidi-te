
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
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
<body>
<div id="container">
    <h1>用户注册页面</h1>
    <hr />
    <form action="/webshijian/ZhuceServlet" method="post">
        <label>用户名：
            <input type="text" placeholder="请输入用户名" name="username" required />
        </label>
        <br />
        <label>密　码：
            <input type="password" placeholder="请输入密码" name="pwd" required />
        </label>
        <br />
        <label>确　认：
            <input type="password" placeholder="请再次输入密码" name="pwd1" required />
        </label>
        <br />
        <button type="submit">
            提交注册
        </button>
    </form>
</div>
</body>
</html>
