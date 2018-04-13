<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<script>

function addReview(){

	var id =  document.getElementById("id").value;
	alert("id:" + id);
	
	$.ajax({
		  type: "POST",
		  url: "/addreview",
		  data: { id: id
		 
			        }, // parameters
		   datatype: 'json'
		});
		}

function displayReview(){

	var id =  document.getElementById("id").value;
	alert("id:" + id);
	
	$.ajax({
		  type: "POST",
		  url: "/displayreviews",
		  data: { id: id
		 
			        }, // parameters
		   datatype: 'json'
		});
		}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bookstore</title>
</head>
<body>
<a href = "/">Home</a>
<a href = "/viewallbooks">Back to books</a>

<%-- <input type="hidden" name="id" value="${title}" /> --%>
<h3>Title: <c:out value="${title}"/></h3>
<h3>Price: <c:out value="${price}"/></h3>
<h3>Author: <c:out value="${author}"/></h3>
<h3>Category: <c:out value="${category}"/></h3>
<h3>Image:  <img src="${pageContext.request.contextPath}/resources/images/${image}"></h3>
		
<form:form method="get" action="/addreview/${title}" >
  <textarea rows="4" cols="50" name="comment">
Enter your Review</textarea>
  <input type="submit">
</form:form>

<form:form method="get" action="/displayreview/${title}" >
 
  <input type="submit" value = "See all Reviews">
</form:form>

<a href = "displayreviews">See reviews for this book</a>
<br>
</body>
</html>