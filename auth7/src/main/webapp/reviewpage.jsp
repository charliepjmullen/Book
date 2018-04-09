<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Reviews</h1>
<a href = "/">Home</a><br>

<c:forEach var="o" items="${books}">
			<tr>
				<td width="10%" height="50"><h3><c:out value="${o.username}" /></h3></td>
				 
				 <td> said : </td>
				 
				<td width="3.5%"  height="50"  class="tg-yw4l"><c:out value="${o.comment}" /></td>
				
				 <td> about : </td>
                 
				<td width="3.5%" height="50"  class="tg-yw4l"><c:out value="${o.book_title}" /></td>
				 
			
             </tr>
             <br>
		</c:forEach>
		
</body>
</html>