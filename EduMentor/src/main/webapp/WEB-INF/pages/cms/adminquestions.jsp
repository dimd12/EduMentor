<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 2/12/25
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head.jspf"%>
    <%@include file="../common/styles.jspf"%>
    <title>Question administration</title>

    <style>
        .navbar {
            background-color: #e6e6fa; /* Lavender background as per shared styles */
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); /* Retain the original shadow */
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: #4b0082 !important; /* Retain purple text for links */
        }

        .navbar-brand:hover, .navbar-nav .nav-link:hover {
            color: #9370db !important; /* Lighter purple on hover */
        }
    </style>
</head>
<body>
<%@include file="../common/navbarsidebarlogin.jspf"%>
<div class="container mt-4">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Nr</th>
            <th scope="col">Title</th>
            <th scope="col">Date</th>
            <th scope="col">Author</th>
            <th scope="col">Image</th>
            <th scope="col">Category</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questionList}" var="question">
            <tr>
                <th scope="row">${question.id}</th>
                <td>${question.title}</td>
                <td>${question.dateCreated}</td>
                <td>${question.userId.username} ${question.userId.firstName}</td>
                <td>
                    <img src="${question.imageUrl}" alt="Image" width="100" height="100" />
                </td>
                <td>${question.categoryId.categoryName}</td>
                <td>
                    <a href="edit-question.html?id=${question.id}">Edit</a> |
                    <a href="delete-question.html?id=${question.id}">Delete</a>
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
