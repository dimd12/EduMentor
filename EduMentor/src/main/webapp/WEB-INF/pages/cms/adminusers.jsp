<%--
  Created by IntelliJ IDEA.
  User: adima
  Date: 2/13/2025
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head.jspf"%>
    <%@include file="../common/styles.jspf"%>
    <title>User administration</title>
    <style>
        .navbar {
            background-color: #e6e6fa;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: #4b0082 !important;
        }

        .navbar-brand:hover, .navbar-nav .nav-link:hover {
            color: #9370db !important;
        }
    </style>
</head>
<body>
<%@include file="../common/navbarsidebarlogin.jspf"%>

<div class="container mt-4">
    <h1>User Administration</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Nr</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Name</th>
            <th scope="col">Profile Picture</th>
            <th scope="col">Bio</th>
            <th scope="col">Role</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <th scope="row">${user.userId}</th>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.firstName} ${user.lastName}</td>
                <td>
                    <img src="${user.profilePictureUrl}" alt="Image" width="100" height="100" />
                </td>
                <td>${user.bio}</td>
                <td>${user.roleId.roleName}</td>
                <td>
                    <a href="delete-user.html?id=${user.userId}">
                        <button style="background-color: red; color: white; border: none; font-size: 14px; padding: 8px 16px; border-radius: 8px;">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../common/footer.jspf"%>
<%@include file="../common/footerscripts.jspf"%>
</body>
</html>
