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
<form action="/student-app/allGroups" method="POST">
<input type="submit" value="Delete checked"/>
   <table class="table table-bordered">
   <thead>
     <tr>
       <th>Group Number</th>
       <th>Average Mark</th>
     </tr>
   </thead>
   <tbody>
     <c:forEach items="${groups}" var="group">
       <tr>
         <td>${group.groupNumber}</td>
         <td>${group.averageMark}</td>
         <td><input type="checkbox" name="groupNumber" value="${group.groupNumber}"></td>
       </tr>
     </c:forEach>
   </tbody>
 </table> 
 </form>
 <ul class="nav nav-pills"> 
  <li role="presentation" class="active"><a href="http://localhost:8080/student-app/addGroup">Add Group</a></li> 
  </ul>
</body>