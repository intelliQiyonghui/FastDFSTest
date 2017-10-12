<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/28
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
         <form action="${pageContext.request.contextPath}/doUpload"
               method="post" enctype="multipart/form-data">
             图片标题:<input type="text" name="picTitle"/> </br>
             图片文件:<input name="pictureFile" type="file"/> </br>
             <input type="submit" value="上传">
         </form>
</body>
</html>
