<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   

<%@ page isELIgnored='false' %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<body>
<form action="/student-app/allStudents" method="POST">
<input type="submit" value="Delete checked"/>
   <table class="table table-bordered">
   <thead>
     <tr>
       <th>First Name</th>
       <th>Second Name</th>
     </tr>
   </thead>
   <tbody>
     <c:forEach items="${students}" var="student">
       <tr>
         <td>${student.firstName}</td>
         <td>${student.secondName}</td>
         <td><input type="checkbox" name="id" value="${student.id}"></td>
       </tr>
     </c:forEach>
   </tbody>
 </table> 
 </form>
 <ul class="nav nav-pills"> 
  <li role="presentation" class="active"><a href="http://localhost:8080/student-app/addStudent">Add Student</a></li> 
  </ul>
</body>