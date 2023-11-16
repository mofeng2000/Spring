<%--
  Created by IntelliJ IDEA.
  User: 89508
  Date: 2022/1/12
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/quick24" enctype="multipart/form-data">

    名称 <input type="text" name="username"><br>
    文件1 <input type="file" name="uploadFile"><br>
    文件2 <input type="file" name="uploadFile"><br>
    文件2 <input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>
<%--<form method="post" action="${pageContext.request.contextPath}/user/quick23" enctype="multipart/form-data">--%>

<%--    名称 <input type="text" name="username"><br>--%>
<%--    文件1 <input type="file" name="uploadFile1"><br>--%>
<%--    文件2 <input type="file" name="uploadFile2"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
