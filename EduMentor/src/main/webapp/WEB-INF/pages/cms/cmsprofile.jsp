<%-- 
    Document   : cmsprofile
    Created on : Feb 7, 2025, 4:07:51 PM
    Author     : adrian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../common/head.jspf"%>
    <%@include file="../common/styles.jspf"%>
    <title>Edit Profile</title>
</head>
<body>
<%@include file="../common/navbarsidebarlogin.jspf"%>

<h1>Edit Profile</h1>

<!-- Profile Edit Form -->
<form action="cmsprofileeditserv" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="${user.userId}" />

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${user.username}" readonly />
    <br><br>

    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${user.firstName}" required />
    <br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required />
    <br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required />
    <br><br>

    <label for="bio">Bio:</label>
    <textarea id="bio" name="bio" rows="4" cols="50">${user.bio}</textarea>
    <br><br>

    <label for="profilePictureUrl">Profile Picture URL:</label>
    <input type="url" id="profilePictureUrl" name="profilePictureUrl" value="${user.profilePictureUrl}" />
    <br><br>

    <button type="submit">Update Profile</button>

</form>

<%@include file="../common/footer.jspf"%>
<%@include file="../common/footerscripts.jspf"%>
</body>
</html>