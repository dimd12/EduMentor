/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.95
 * Generated at: 2025-02-07 14:21:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("jar:file:/home/adrian/Documents/EduMentor/EduMentor/EduMentor/target/EduMentor-1.0-SNAPSHOT/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/pages/common/styles.jspf", Long.valueOf(1738677663000L));
    _jspx_dependants.put("/WEB-INF/pages/common/navbarsidebarnologin.jspf", Long.valueOf(1738938001000L));
    _jspx_dependants.put("/WEB-INF/pages/common/head.jspf", Long.valueOf(1738677663000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1727442631000L));
    _jspx_dependants.put("/WEB-INF/pages/common/footer.jspf", Long.valueOf(1738782226000L));
    _jspx_dependants.put("/WEB-INF/pages/common/footerscripts.jspf", Long.valueOf(1738677980000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"../../../resources/styles/styles.css\">\n");
      out.write("<link rel=\"icon\" href=\"#\" type=\"image/gif\">\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" \n");
      out.write("      rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" \n");
      out.write("      crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        ");
      out.write("<style>\n");
      out.write("    html, body {\n");
      out.write("        min-height: 100vh;\n");
      out.write("        display: flex;\n");
      out.write("        flex-direction: column;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    body {\n");
      out.write("        padding-top: 60px;\n");
      out.write("        background-color: #f8f9fa; /* Light background */\n");
      out.write("        color: #4b0082; /* Dark purple text */\n");
      out.write("        font-family: 'Arial', sans-serif;\n");
      out.write("        display: flex;\n");
      out.write("        flex-direction: column;\n");
      out.write("        min-height: 100vh;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navbar {\n");
      out.write("        background-color: #e6e6fa; /* Lavender background for navbar */\n");
      out.write("        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navbar-brand, .navbar-nav .nav-link {\n");
      out.write("        color: #4b0082 !important; /* Purple text */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navbar-brand:hover, .navbar-nav .nav-link:hover {\n");
      out.write("        color: #9370db !important; /* Lighter purple on hover */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .offcanvas-sidebar {\n");
      out.write("        width: 20%;\n");
      out.write("        background-color: #e6e6fa; /* Lavender background for sidebar */\n");
      out.write("        padding: 20px;\n");
      out.write("        color: #4b0082; /* Purple text */\n");
      out.write("        display: flex;\n");
      out.write("        flex-direction: column;\n");
      out.write("        justify-content: space-between;\n");
      out.write("        height: 100%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .offcanvas-sidebar .list-group-item {\n");
      out.write("        background-color: #f3e5f5; /* Light purple for list items */\n");
      out.write("        color: #4b0082; /* Purple text */\n");
      out.write("        border: none;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .offcanvas-sidebar .list-group-item.disabled {\n");
      out.write("        opacity: 0.6;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-panel button {\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("        background-color: #9370db; /* Medium purple buttons */\n");
      out.write("        color: white;\n");
      out.write("        border: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-panel button:hover {\n");
      out.write("        background-color: #ba55d3; /* Bright purple on hover */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .login-message {\n");
      out.write("        text-align: center;\n");
      out.write("        margin-top: 20px;\n");
      out.write("        font-size: 1rem;\n");
      out.write("        color: #8a2be2; /* Purple warning text */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-success {\n");
      out.write("        background-color: #9370db; /* Medium purple buttons */\n");
      out.write("        border-color: #9370db;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-success:hover {\n");
      out.write("        background-color: #ba55d3; /* Bright purple on hover */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-outline-success {\n");
      out.write("        color: #4b0082; /* Purple outline buttons */\n");
      out.write("        border-color: #4b0082;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-outline-success:hover {\n");
      out.write("        color: white;\n");
      out.write("        background-color: #9370db; /* Medium purple on hover */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container.content {\n");
      out.write("        margin-top: 30px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .content {\n");
      out.write("        flex: 1;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Footer styling */\n");
      out.write("    .footer {\n");
      out.write("        background-color: #e6e6fa; /* Lavender background */\n");
      out.write("        color: #4b0082; /* Purple text */\n");
      out.write("        text-align: center;\n");
      out.write("        padding: 20px 0;\n");
      out.write("        margin-top: auto; /* Pushes footer to the bottom */\n");
      out.write("        box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1); /* Subtle shadow for separation */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .footer p {\n");
      out.write("        margin: 0;\n");
      out.write("        font-size: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Container for consistent spacing */\n");
      out.write("    .container {\n");
      out.write("        max-width: 1200px;\n");
      out.write("        margin: 0 auto;\n");
      out.write("        padding: 0 15px;\n");
      out.write("    }\n");
      out.write("</style>");
      out.write("\n");
      out.write("        <title>LogIn</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            html, body {\n");
      out.write("                min-height: 100vh;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                background-color: #f8f9fa; /* Light background */\n");
      out.write("                color: #4b0082; /* Dark purple text */\n");
      out.write("                font-family: 'Arial', sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-container {\n");
      out.write("                max-width: 400px;\n");
      out.write("                margin: auto;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                padding: 20px;\n");
      out.write("                background-color: #e6e6fa; /* Lavender background */\n");
      out.write("                border-radius: 10px;\n");
      out.write("                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-container h2 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #4b0082; /* Purple text */\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-control {\n");
      out.write("                border-color: #4b0082; /* Purple border */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-control:focus {\n");
      out.write("                box-shadow: 0 0 5px #9370db; /* Medium purple glow */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-primary {\n");
      out.write("                background-color: #9370db; /* Medium purple buttons */\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-primary:hover {\n");
      out.write("                background-color: #ba55d3; /* Bright purple on hover */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .toggle-link {\n");
      out.write("                color: #4b0082; /* Purple text for toggle link */\n");
      out.write("                cursor: pointer;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .footer {\n");
      out.write("                background-color: #e6e6fa; /* Lavender background */\n");
      out.write("                color: #4b0082; /* Purple text */\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 20px 0;\n");
      out.write("                margin-top: auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark fixed-top\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <button class=\"btn btn-secondary\" type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#offcanvasSidebar\" aria-controls=\"offcanvasSidebar\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <a class=\"navbar-brand ms-3\" href=\"/\">EduMentor</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarContent\" aria-controls=\"navbarContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarContent\">\n");
      out.write("            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" aria-current=\"page\" href=\"discover.html\">Discover</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"about.html\">About Us</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                        Choose the lesson you want\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-menu-dark\">\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Informatics</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Maths</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Romanian</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <ul class=\"navbar-nav ms-auto mb-2 mb-lg-0\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">En</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link disabled\" aria-current=\"page\" href=\"#\">|</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Ro</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <form class=\"d-flex ms-3\" role=\"search\">\n");
      out.write("                <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                <button class=\"btn btn-success\" type=\"submit\">Search</button>\n");
      out.write("            </form>\n");
      out.write("            <form class=\"d-flex ms-3\">\n");
      out.write("                <a href=\"/login.jsp\">\n");
      out.write("                    <button class=\"btn btn-outline-success\" type=\"button\">Log In</button>\n");
      out.write("                </a>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<div class=\"offcanvas offcanvas-start offcanvas-sidebar\" tabindex=\"-1\" id=\"offcanvasSidebar\" aria-labelledby=\"offcanvasSidebarLabel\">\n");
      out.write("    <div class=\"offcanvas-header\">\n");
      out.write("        <h5 class=\"offcanvas-title\" id=\"offcanvasSidebarLabel\">Your Settings</h5>\n");
      out.write("        <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\"></button>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"offcanvas-body\">\n");
      out.write("        <div class=\"login-message\">\n");
      out.write("            <p>Login required to access these options.</p>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"list-group\">\n");
      out.write("            <li class=\"list-group-item disabled\">My Profile</li>\n");
      out.write("            <li class=\"list-group-item disabled\">Ask a question</li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"d-grid\" style=\"position: absolute;\">\n");
      out.write("            <a href=\"/login.jsp\">\n");
      out.write("                <button class=\"btn btn-outline-success\" type=\"button\">Log In</button>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <!-- Login Form -->\n");
      out.write("            <div id=\"loginForm\">\n");
      out.write("                <h2>Login</h2>\n");
      out.write("                <form action=\"cmsloginserv\" method=\"POST\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"loginUsername\" class=\"form-label\">Username</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"uname\" name=\"username\" placeholder=\"Enter your username\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"loginPassword\" class=\"form-label\">Password</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" id=\"pass\" name=\"password\" placeholder=\"Enter your password\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary w-100\">Log In</button>\n");
      out.write("                    <p class=\"text-center mt-3\">Don't have an account? \n");
      out.write("                        <span class=\"toggle-link\" onclick=\"toggleForms()\">Sign Up</span>\n");
      out.write("                    </p>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Sign-Up Form -->\n");
      out.write("            <div id=\"signUpForm\" style=\"display:none;\">\n");
      out.write("                <h2>Sign Up</h2>\n");
      out.write("                <form id=\"signUpMainForm\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"username\" class=\"form-label\">Username</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"Enter your username\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"emailSignUp\" class=\"form-label\">Email address</label>\n");
      out.write("                        <input type=\"email\" class=\"form-control\" id=\"emailSignUp\" placeholder=\"Enter your email\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"firstName\" class=\"form-label\">First Name</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"firstName\" placeholder=\"Enter your first name\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"lastName\" class=\"form-label\">Last Name</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"lastName\" placeholder=\"Enter your last name\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"passwordSignUp\" class=\"form-label\">Password</label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" id=\"passwordSignUp\" placeholder=\"Create a password\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"dobSignUp\" class=\"form-label\">Date of Birth</label>\n");
      out.write("                        <input type=\"date\" class=\"form-control\" id=\"dobSignUp\">\n");
      out.write("                    </div>\n");
      out.write("                    <!-- User Type Selection -->\n");
      out.write("                    <div class=\"\">\n");
      out.write("                        <label for=\"\" class=\"\">Would you like to be:</label>\n");
      out.write("                        <select class=\"form-control\" id=\"userType\">\n");
      out.write("                            <option value=\"mentee\">Mentee</option>\n");
      out.write("                            <option value=\"mentor\">Mentor</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary w-100 mt-3\" onclick=\"handleSignUp()\">Sign Up</button>\n");
      out.write("                    <p class=\"text-center mt-3\">Already have an account? \n");
      out.write("                        <span class=\"toggle-link\" onclick=\"toggleForms()\">Log In</span>\n");
      out.write("                    </p>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Mentor Additional Form -->\n");
      out.write("            <div id=\"mentorForm\" style=\"display:none;\">\n");
      out.write("                <h2>Mentor Application</h2>\n");
      out.write("                <form id=\"mentorApplicationForm\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"schoolName\" class=\"form-label\">School Name</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"schoolName\" placeholder=\"Enter your school name\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"schoolResults\" class=\"form-label\">School Results</label>\n");
      out.write("                        <textarea class=\"form-control\" id=\"schoolResults\" rows=\"3\" placeholder=\"Provide your school results\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"olympiadResults\" class=\"form-label\">Olympiad Results</label>\n");
      out.write("                        <textarea class=\"form-control\" id=\"olympiadResults\" rows=\"3\" placeholder=\"Provide your olympiad results (if any)\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"cvUpload\" class=\"form-label\">Upload CV</label>\n");
      out.write("                        <input type=\"file\" class=\"form-control\" id=\"cvUpload\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary w-100\">Submit Application</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function toggleForms() {\n");
      out.write("                const loginForm = document.getElementById('loginForm');\n");
      out.write("                const signUpForm = document.getElementById('signUpForm');\n");
      out.write("                const mentorForm = document.getElementById('mentorForm');\n");
      out.write("\n");
      out.write("                // Reset all forms and hide mentor form\n");
      out.write("                mentorForm.style.display = 'none';\n");
      out.write("\n");
      out.write("                if (loginForm.style.display === 'none') {\n");
      out.write("                    loginForm.style.display = 'block';\n");
      out.write("                    signUpForm.style.display = 'none';\n");
      out.write("                } else {\n");
      out.write("                    loginForm.style.display = 'none';\n");
      out.write("                    signUpForm.style.display = 'block';\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function handleSignUp() {\n");
      out.write("                const userType = document.getElementById('userType').value;\n");
      out.write("\n");
      out.write("                if (userType === 'mentor') {\n");
      out.write("                    // Show mentor application form\n");
      out.write("                    document.getElementById('signUpForm').style.display = 'none';\n");
      out.write("                    document.getElementById('mentorForm').style.display = 'block';\n");
      out.write("                } else {\n");
      out.write("                    // Proceed with mentee sign-up process (e.g., send data to server)\n");
      out.write("                    alert('Mentee account created successfully!');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
      out.write("<footer class=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <p>&copy; 2025 EduMentor. All rights reserved.</p>\n");
      out.write("        <p>Today's Date: <span id=\"currentDate\"></span></p>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write("\n");
      out.write("        ");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\" \n");
      out.write("        integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\" \n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js\" \n");
      out.write("        integrity=\"sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy\" \n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("// Function to format the date as \"Day, Month DD, YYYY\"\n");
      out.write("function updateFooterDate() {\n");
      out.write("    const options = {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'};\n");
      out.write("    const today = new Date();\n");
      out.write("    const formattedDate = today.toLocaleDateString('en-US', options);\n");
      out.write("\n");
      out.write("    // Set the formatted date in the footer\n");
      out.write("    document.getElementById('currentDate').textContent = formattedDate;\n");
      out.write("}\n");
      out.write("\n");
      out.write("updateFooterDate();\n");
      out.write("</script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
