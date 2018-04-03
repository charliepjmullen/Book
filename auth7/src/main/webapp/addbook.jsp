<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function saveAreaToUser(){

		var title = document.getElementById("addressBox").value;
		var price = document.getElementById("schoolAvgRating").value;
		var author = document.getElementById("parkAvgRating").value;
		var bar = document.getElementById("barAvgRating").value;
		var gym = document.getElementById("gymAvgRating").value;
		var restaurant = document.getElementById("restaurantAvgRating").value;  
	  
	$.ajax({
  type: "POST",
  url: "/saveAreaToProfile",
  data: { latitude: Lat, 
          longitude: Long,  
          areaName: areaName,
          schools: schools,
          parks: university,
          bar: bar,
          gym: gym,
          restaurant: restaurant
	        }, // parameters
   datatype: 'json'
});
}

</script>
</head>
<body>

  <h3>Welcome, Enter The Book Details</h3>
        <form:form method="POST" action="/addBook" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">Contact Number</form:label></td>
                    <td><form:input path="contactNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>