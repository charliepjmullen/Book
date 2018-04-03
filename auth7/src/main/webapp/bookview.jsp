<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bookstore</title>
</head>
<body>
<a href = "/">Home</a>
<a href = "/viewallbooks">Back to books</a>

<h3>Title: <c:out value="${title}"/></h3>
<h3>Price: <c:out value="${price}"/></h3>
<h3>Author: <c:out value="${author}"/></h3>
<h3>Category: <c:out value="${category}"/></h3>
<h3>Image: <c:out value="${image}"/></h3>
		
<form:form method="get" action="/book/${id}/addreview">
  <textarea rows="4" cols="50" name="review">
Enter your Review</textarea>
  <input type="submit">
</form:form>
<br>
</body>
</html>