<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加账户信息表单</h2>
<form name="accountForm" action="${pageContext.request.contextPath}/account/add" method="post">
    账户名称：<input name="name" type="text"> <br>
    账户金额：<input name="money" type="text"> <br>
    <input type="submit" value="提交"> <br>
</form>
</body>
</html>
