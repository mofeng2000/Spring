<%--
  Created by IntelliJ IDEA.
  User: 89508
  Date: 2022/1/12
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script src="${pageContext.request.contextPath}/js/jquery-2.0.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/axios-0.18.0.js"></script>
<script>
    var userList = new Array();
    userList.push({username: "zs", age: 18});
    userList.push({username: "ls", age: 18});
    axios({
        method: "post",
        url: "${pageContext.request.contextPath}/user/quick15",
        data: userList
    })
    <%--$.ajax({--%>
    <%--    type:"post",--%>
    <%--    url: "${pageContext.request.contextPath}/user/quick15",--%>
    <%--    data:JSON.stringify(userList),--%>
    <%--    contentType:"application/json;charset=utf-8"--%>
    <%--})--%>
</script>
</body>
</html>
