<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Quantity</title>

</head>
<script>

function addBookQuantity(){

	var id =  document.getElementById("id").value;
	alert("id:" + id);
	
	$.ajax({
		  type: "POST",
		  url: "/shoppingCart",
		  data: { id: id
		 
			        }, // parameters
		   datatype: 'json'
		});
		}</script>
<body>
<h1 >Update Quantity</h1>



<h3>Title: <c:out value="${title}"/></h3>
<h3>Price: <c:out value="${price}"/></h3>
<h3>Author: <c:out value="${author}"/></h3>
<h3>Category: <c:out value="${category}"/></h3>
<h3>Image:  <img src="${pageContext.request.contextPath}/resources/images/${image}"></h3>
		
<form:form method="get" action="/updatequantity/${title}" >
   <input name="quantity"></input>
  <input type="submit">
</form:form>


</body>
</html>