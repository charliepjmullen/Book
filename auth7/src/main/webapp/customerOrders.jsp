<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Orders</title>
</head>
<body>

<h1>Customer orders</h1>
<a href = "/">Home</a>
 <table>
    <tr>
        <th class="tg-address">User</th>
		<th></th>
        <th class="tg-houseprice">Shipping Address</th>
		<th></th>
        <th  class="tg-crimerating">Purchased Books</th>



        <th  class="tg-bars"> </th>
    </tr>

    <c:forEach var="o" items="${purchaseHistory}">
        <tr>
            <td width="3.5%" height="50"><c:out value="${o.username}"/></td>
			<td></td>
            <td width="10%" height="50"><c:out value="${o.shipping_address}"/></td>
			<td></td>
            <td width="20%" height="50"><c:out value="${o.purchaseHistory}"/></td>

     

         </tr>
    </c:forEach>
</table>

</body>
</html>