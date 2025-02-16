<%--
    Document   : login
    Created on : Feb 5, 2025, 10:08:27 AM
    Author     : adima
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="common/head.jspf" %>
    <%@include file="common/styles.jspf" %>
    <title>LogIn</title>

    <style>
        html, body {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            background-color: #f8f9fa; /* Light background */
            color: #4b0082; /* Dark purple text */
            font-family: 'Arial', sans-serif;
        }

        .form-container {
            max-width: 400px;
            margin: auto;
            margin-top: 50px;
            padding: 20px;
            background-color: #e6e6fa; /* Lavender background */
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            text-align: center;
            color: #4b0082; /* Purple text */
            margin-bottom: 20px;
        }

        .form-control {
            border-color: #4b0082; /* Purple border */
        }

        .form-control:focus {
            box-shadow: 0 0 5px #9370db; /* Medium purple glow */
        }

        .btn-primary {
            background-color: #9370db; /* Medium purple buttons */
            color: white;
            border: none;
        }

        .btn-primary:hover {
            background-color: #ba55d3; /* Bright purple on hover */
        }

        .toggle-link {
            color: #4b0082; /* Purple text for toggle link */
            cursor: pointer;
            text-decoration: underline;
        }

        .footer {
            background-color: #e6e6fa; /* Lavender background */
            color: #4b0082; /* Purple text */
            text-align: center;
            padding: 20px 0;
            margin-top: auto;
        }

        .error-message {
            color: red;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>

</head>
<body>
<%@include file="common/navbarsidebarnologin.jspf" %>

<div class="form-container">
    <!-- Display error message if any -->
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <!-- Login Form -->
    <div id="loginForm">
        <h2>Login</h2>
        <form action="cmsloginserv" method="POST">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="uname" name="username" placeholder="Enter your username">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="pass" name="password" placeholder="Enter your password">
            </div>
            <button type="submit" class="btn btn-primary w-100">Log In</button>
            <p class="text-center mt-3">Don't have an account?
                <span class="toggle-link" onclick="toggleForms()">Sign Up</span>
            </p>
        </form>
    </div>

    <!-- Sign-Up Form -->
    <div id="signUpForm" style="display:none;">
        <h2>Sign Up</h2>
        <form id="signUpMainForm" action="cmssignupserv" method="POST" onsubmit="return validateSignUpForm()">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter your first name">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter your last name">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Create a password">
            </div>
            <button type="submit" class="btn btn-primary w-100 mt-3">Sign Up</button>
            <p class="text-center mt-3">Already have an account?
                <span class="toggle-link" onclick="toggleForms()">Log In</span>
            </p>
        </form>
    </div>
</div>

<script>
    function toggleForms() {
        const loginForm = document.getElementById('loginForm');
        const signUpForm = document.getElementById('signUpForm');

        if (loginForm.style.display === 'none') {
            loginForm.style.display = 'block';
            signUpForm.style.display = 'none';
        } else {
            loginForm.style.display = 'none';
            signUpForm.style.display = 'block';
        }
    }

    function validateSignUpForm() {
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const password = document.getElementById('password').value;

        // Email regex pattern
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!username || !email || !firstName || !lastName || !password) {
            alert('Please fill in all fields.');
            return false;
        }

        if (username.length < 4) {
            alert('Username must be at least 4 characters long.');
            return false;
        }

        if (!emailPattern.test(email)) {
            alert('Please enter a valid email address.');
            return false;
        }

        return true;
    }
</script>

<%@include file="common/footer.jspf" %>
<%@include file="common/footerscripts.jspf" %>
</body>
</html>
