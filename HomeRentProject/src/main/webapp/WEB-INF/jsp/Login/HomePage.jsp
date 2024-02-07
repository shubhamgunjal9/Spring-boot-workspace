<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/w3.css"> 
<title>Insert title here</title>

<style type="text/css">
img{
   margin-top: -15px;
   margin-left: -180px;
   margin-bottom : -35px;
   height : 530px;
   width: 1345px;
}
</style>
</head>
 <body>

<div class="w3-content w3-section">
  <img class="mySlides w3-animate-top" src="img/HomePage.jpg">
  <img class="mySlides w3-animate-left" src="img/homePage/home1.jpg">
 <!--  <img class="mySlides w3-animate-right" src="img/homePage/home2.jpg"> -->
  <img class="mySlides w3-animate-bottom" src="img/homePage/home5.jpg">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 5000);    
}
</script>
</body>
</html> 