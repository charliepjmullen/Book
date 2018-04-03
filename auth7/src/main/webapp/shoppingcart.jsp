<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">

	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
 <h3>Your Shopping Cart</h3>
 
 <a href = "/">Home</a>
	
	   <table>
	   <tr>
	        <th></th>
	        <th class="tg-address">Title</th>
			<th></th>
			<th class="tg-houseprice">Price</th>
			<th></th>
			<th  class="tg-crimerating">Author</th>
			 <th></th>
			<th  class="tg-schools">Category</th>
			 <th></th>
			<th  class="tg-university">Book Cover</th>

		</tr>
		
		<c:forEach var="o" items="${shoppingCart}" varStatus="loopStatus">
			<tr>			
			    <td></td>
				<td   height="50"><c:out value="${o.title}"/></td>
				<td></td>
                <td  height="50"><c:out value="${o.price}"/></td>
                 <td></td>
                <td  height="50"><c:out value="${o.author}"/></td>
                 <td></td>
				<td  height="50"><c:out value="${o.category}"/></td>
				 <td></td>
				<td  height="50"><c:out value="${o.image}"/></td>
								<td><a href="<c:url value='/deletebook/${o.id}' />">
   							Remove 
 					 </a>
 			    </td>  
             </tr>
		</c:forEach>
        </table>
        
        <a href = "checkout">Proceed to Checkout</a>
</body>
</html>