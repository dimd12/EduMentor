<%--
    Document   : index
    Created on : Feb 2, 2025, 11:20:14 AM
    Author     : adrian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="../common/head.jspf" %>
  <%@include file="../common/styles.jspf" %>
  <title>EduMentor</title>
</head>
<body>
<%@include file="../common/navbarsidebarlogin.jspf" %>
<img src="${user.profilePictureUrl}" width="100" height="100">
<h1>Hi, ${user.username}!</h1>

<%@include file="../common/footer.jspf" %>

<%@include file="../common/footerscripts.jspf" %>
</body>
</html>
