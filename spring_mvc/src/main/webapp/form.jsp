<%--
  Created by IntelliJ IDEA.
  User: 89508
  Date: 2022/1/12
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick14" method="post">
<%--    表明第一个User对象的username age--%>
    <h2>${pageContext.request.contextPath}</h2>
    <input type="text" name="userList[0].username"><br>
    <input type="text" name="userList[0].age"><br>
    <input type="text" name="userList[1].username"><br>
    <input type="text" name="userList[1].age"><br>
    <input type="submit" value="提交"></input>
</form>
</body>
</html>
