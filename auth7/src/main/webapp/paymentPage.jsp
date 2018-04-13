<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>

function getpaymentdetails(){

	var shipping = document.getElementById("address").value;
	var creditcard = document.getElementById("cardtype").value;
	var expirydate = document.getElementById("expirydate").value;
	var carddetails = document.getElementById("cardnumber").value;
	var cvv = document.getElementById("cvv").value;

	$.ajax({
	     type: "GET",
	     url: "/paymentDetails",
	     data: { shipping: shipping, 
	    	     creditcard: creditcard,  
	    	     expirydate: expirydate,
	    	     carddetails: carddetails,
	    	     cvv: cvv
		        }, // parameters
		        contentType: "application/json; charset=utf-8",
         datatype: 'json'
});
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Total: <c:out value="${total}"/></h3>


  Shipping Address: <input type="text" name="address" id="address"/><br>
  Credit Card Type: <input type="text" name="cardtype" id="cardtype"/><br>
  Expiry Date:      <input type="month" name="expirydate" id="expirydate"><br>
  Card Number:      <input type="number" name="cardnumber" id="cardnumber"/><br>
  CVV Number:       <input type="number" name="cvv" id="cvv" min="1" max="3"/><br>

  <a onclick="getpaymentdetails()" href="paymentpage">Submit</a>
  

</body>
</html>