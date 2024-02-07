<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login page</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <input type="checkbox" id="show">
    <label for="show" class="show-btn">login</label>

    <div class="container">
        <label for="show" class="close-btn" title="close">×</label>
        <h1>Welcome</h1>
        <form action="#">
            <label>Email or Phone</label>
            <input type="text">
            <label>Password</label>
            <input type="password">
            <a href="#">Forgot Password?</a>
            <button>Submit<a></a></button>
            <div class="link">Not a member? <a href="#">Sigup here</a></div>
            <a href="/">get back</a>
            
        <closeform></closeform></form>
    </div>

    <!-- Slideshow container -->
 <div class="slideshow-container">

    Full-width images with number and caption text
    <div class="mySlides fade">
      <div class="numbertext">1 / 3</div>
      <img src="https://assets.entrepreneur.com/content/3x2/2000/20160422124659-sonnen-2.jpeg" style="width:100%">
      <div class="text">Caption Text</div>
    </div>
  
    <div class="mySlides fade">
      <div class="numbertext">2 / 3</div>
      <img src="https://img.freepik.com/premium-photo/game-developer-sitting-creative-agency-office-workspace-while-designing-game-level-electronic-arts-company-employee-working-3d-project-while-modeling-environment_482257-40468.jpg" style="width:100%">
      <div class="text">Caption Two</div>
    </div>
  
    <div class="mySlides fade">
      <div class="numbertext">3 / 3</div>
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIWlXxLpwq8pI3p07HzuAnvjKrgF7puEQRKw&usqp=CAU" style="width:100%">
      <div class="text">Caption Three</div>
    </div>
  
    Next and previous buttons
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
  </div>
  <br>
  
  The dots/circles
  <div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
  </div> 
</body>
</html>
