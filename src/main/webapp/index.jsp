<%--
  Created by IntelliJ IDEA.
  User: jacka
  Date: 2019/8/18
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>传统方式文件上传</h3>
    <br>
    <form action="file/fileupload1" method="post" enctype="multipart/form-data">
        选择文件： <input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <h3>Spring MVC方式文件上传</h3>
    <br>
    <form action="file/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件： <input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
