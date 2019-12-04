<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/11/30
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">查询用户信息&emsp; <a href="${pageContext.request.contextPath}/user/insert.jsp">新增</a></p>
<table border="1" align="center" cellpadding="5" cellspacing="0" width="850" bgcolor="pink">
    <tr bgcolor="#adff2f">
        <th>头像</th>
        <th>顺序</th>
<%--        <th>用户编号</th>--%>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>用户年龄</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="people" varStatus="status" >
            <tr align="center">
                <td><img src="${pageContext.request.contextPath}/${people.userId}.png" width="30px" height="30px"></td>
                <td>${status.count}</td>
                <td hidden>${people.userId}</td>
                <td>${people.userName}</td>
                <td>${people.userPass}</td>
                <td>${people.userAge}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/ShowUpdateServlet?id=${people.userId}">修改</a>
                    |
                    <a href="${pageContext.request.contextPath}/DeleteServlet?id=${people.userId}">删除</a>
                    |
                    <a href="${pageContext.request.contextPath}/user/fileUpload.jsp?id=${people.userId}">上传头像</a>

                </td>
            </tr>
        </c:forEach>
    </c:if>

</table>
</body>
</html>
