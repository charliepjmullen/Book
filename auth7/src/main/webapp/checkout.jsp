<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<form action="/action_page.php">
  Promo Code: <input type="text" name="promocode">
  <input type="submit" value="Apply Discount">
</form><br>


<a href="/payment">Proceed to Checkout</a>
</body>
</html>