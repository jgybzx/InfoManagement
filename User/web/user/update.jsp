<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/30
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">修改用户信息</p>
<div style="margin:auto;width:500px;background-color: pink;">
    <form action="${pageContext.request.contextPath}/UpdateServlet" method="post" style="width:300px;margin:auto;">
        用户编号<input type="text" name="userId" value="${people.userId}" hidden/><br/>
        用户姓名<input type="text" name="userName" value="${people.userName}" /><br/>
        用户密码<input type="password" name="userPass" value="${people.userPass}" /><br/>
        用户年龄<input type="text" name="userAge" value="${people.userAge}" /><br/>
        <button type="reset">重置</button><button type="submit">提交</button>
    </form>
</div>
</body>
</html>
