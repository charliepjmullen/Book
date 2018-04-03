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
<script>

function addBook(){

	var id =  document.getElementById("id").value;
	alert("id:" + id);
	
	$.ajax({
		  type: "POST",
		  url: "/shoppingCart",
		  data: { id: id
		 
			        }, // parameters
		   datatype: 'json'
		});
		}


</script>

<body>
 <h3>Some of our Books</h3>
 
 <a href = "/">Home</a>
	
	<table>
	<tr>
	        <th></th>
	        <th class="tg-address">Title</th>
			
			<th class="tg-houseprice">Price</th>
			
			<th  class="tg-crimerating">Author</th>
			 
			<th  class="tg-schools">Category</th>
			 
			<th  class="tg-university">Book Cover</th>
			 
			<th  class="tg-bars">Amount in Stock</th>

            <th  class="tg-bars"> </th>
		</tr>
		
		<c:forEach var="o" items="${booksList}" varStatus="loopStatus">
			<tr>
                <td id = "id" width="3.5%"><c:out value="${booksList[loopStatus.index].id}"/></td>			
			
				<td  width="3.5%" height="50"><c:out value="${o.title}"/></td>
				
                <td width="3.5%" height="50"><c:out value="${o.price}"/></td>
                 
                <td width="3.5%" height="50"><c:out value="${o.author}"/></td>
                 
				<td width="3.5%" height="50"><c:out value="${o.category}"/></td>
				 
				<td width="3.5%" height="50"><c:out value="${o.image}"/></td>
				 
				<td width="3.5%" height="50"><c:out value="${o.quantity}"/></td>
				
								 	<td><a href="<c:url value='/book/${o.id}' />">
   							 View Book and Reviews
 					 </a>
 			    </td>
				 
				<td><a href="<c:url value='/shoppingcart/${o.id}' />">
   							 Add Book to Shopping Cart
 					 </a>
 			    </td>
			   
             </tr>
		</c:forEach>
		
</table>
</body>
</html>