<%--
  Created by IntelliJ IDEA.
  User: w
  Date: 2021/9/17
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file</title>
</head>
<body>
    file ok ---------
    <form action="/file/download" enctype="multipart/form-data" method="post">
        <input type="text" name="file" value="${file}"/><br>
        <button type="submit">文件下载</button>
    </form>

</body>
</html>
