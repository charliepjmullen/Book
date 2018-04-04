<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

/* function saveAreaToUser(){

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
} */

</script>
</head>
<body>

  <h3>Enter The Book Details</h3>
  <a href="/">Home</a><br>

<form method="GET" action="/addbook" id="addBook" name ="addBook">
  Book Title : <input type="text" name="title" id="title"/><br>
  Author: <input type="text" name="author" id="author"/><br>
  Price: <input type="text" name="price" id="price"/><br>
  Category: <input type="text" name="category" id="category"/><br>
  Image: <input type="file" name="image" id="image"/><br>
  Quantity: <input type="text" name="quantity" id="quantity"/><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>