
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style type="text/css">
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
      padding:100px; /* 控制大小 */
      margin: 20px auto 0px; /*控制中间表单的位置*/
      width:600px;
      /*text-align:center;  控制butten 位置*/
      font-family:"微软雅黑 Light";
      /*box-shadow: 10px 10px 15px black;*/
    }

  </style>
</head>
<body>
<div  class="h1" align="center"><h1>投票管理系统</h1></div>
<div class="h3">
  <button class="h2"><h2><a href="${pageContext.request.contextPath}/login">用户登入</a></h2></button><br>
  <button class="h2"><h2><a href="${pageContext.request.contextPath}/glogin">管理员登入</a></h2></button>
</div>

</body>
</html>
