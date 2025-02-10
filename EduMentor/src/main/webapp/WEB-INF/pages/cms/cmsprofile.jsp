<%-- 
    Document   : cmsprofile
    Created on : Feb 7, 2025, 4:07:51 PM
    Author     : adrian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Profile</title>
</head>
<body>
<h1>Edit Profile</h1>

<!-- Profile Edit Form -->
<form action="ProfileServlet" method="post" enctype="multipart/form-data">
    <!-- Hidden field to preserve the unique user ID -->
    <input type="hidden" name="userId" value="${user.userId}" />

    <!-- Username (Read-only) -->
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${user.username}" readonly />
    <br><br>

    <!-- First Name -->
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${user.firstName}" required />
    <br><br>

    <!-- Last Name -->
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required />
    <br><br>

    <!-- Email -->
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required />
    <br><br>

    <!-- Bio -->
    <label for="bio">Bio:</label>
    <textarea id="bio" name="bio" rows="4" cols="50">${user.bio}</textarea>
    <br><br>

    <!-- Profile Picture URL -->
    <label for="profilePictureUrl">Profile Picture URL:</label>
    <input type="url" id="profilePictureUrl" name="profilePictureUrl" value="${user.profilePictureUrl}" />
    <br><br>

    <!-- Submit Button -->
    <button type="submit">Update Profile</button>
</form>
</body>
</html>