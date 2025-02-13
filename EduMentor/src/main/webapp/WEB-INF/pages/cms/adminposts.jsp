<%--
  Created by IntelliJ IDEA.
  User: adima
  Date: 2/12/2025
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@include file="../common/head.jspf"%>
    <%@include file="../common/styles.jspf"%>
    <title>Post administration</title>

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
        <th scope="col">Video</th>
        <th scope="col">Category</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${postList}" var="post">
        <tr>
          <th scope="row">${post.id}</th>
          <td>${post.title}</td>
          <td>${post.dateCreated}</td>
          <td>${post.userId.username} ${post.userId.firstName}</td>
          <td>
            <iframe width="320" height="180"
                    src="${post.videoUrl}"
                    frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope"
                    allowfullscreen>
            </iframe>
          </td>
          <td>${post.categoryId.categoryName}</td>
          <td>
            <a href="edit-post.html?id=${post.id}">Edit</a> |
            <a href="delete-post.html?id=${post.id}">Delete</a>
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
