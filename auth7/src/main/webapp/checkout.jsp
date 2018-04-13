<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<h1>Checkout</h1>

<h3>Total: <c:out value="${total}"/></h3>

<%-- <form method="get" action="calculatediscount">
  Promo Code: <input type="text" name="code">
  <input type="submit" value="Apply Discount">
</form><br> --%>

<form:form method="get" action="calculatediscount">
  Promo Code: <input type="text" name="code">
  <input type="hidden" name = "price" value="${total}">
  <input type="submit" value="Apply Discount">
</form:form> 

<a href="/payment">Proceed to Checkout</a>
</body>
</html>