<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/12/4
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUploadServlet" method="post" enctype="multipart/form-data">
    文件<input type="file"  name="myFile"/><br/>
   <input  hidden name = "id" value="${pageContext.request.getParameter("id")}">
    描述<input type="text" name="myDesc"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
