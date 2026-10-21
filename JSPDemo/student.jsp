<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
<h2>Student Information</h2>
<form method="post">
    Enter Student Name:
    <input type="text" name="name"><br><br>
    Enter Roll Number:
    <input type="text" name="roll"><br><br>
    Enter Course:
    <input type="text" name="course"><br><br>
    Enter Age:
    <input type="text" name="age"><br><br>

    <input type="submit" value="Display Information">
</form>
<%
    String name = request.getParameter("name");
    String roll = request.getParameter("roll");
    String course = request.getParameter("course");
    String age = request.getParameter("age");
    if (name != null) {
%>

<h3>Student Details</h3>
Name: <%= name %><br>
Roll Number: <%= roll %><br>
Course: <%= course %><br>
Age: <%= age %><br>
<%
    }
%>
</body>
</html>