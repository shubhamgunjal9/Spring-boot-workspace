<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book your tickit</title>
<link rel="stylesheet" href="/css/ticket.css">
</head>
<body>
	<nav>
		<img src="/images/train-logo-3.png">
		<ul>
			<li><a href="/" id="nav1">Home</a></li>
			<li><a href="#" id="nav1">About-us</a></li>
			<li><a href="#" id="nav1">Contact-us</a></li>
			<li><a href="/Login" id="nav1">Login</a></li>
			<li><a href="register" id="nav1">Register</a></li>
		</ul>
	</nav>
	<div id="id1">
		<form:form action="logsuccess" modelAttribute="registration" method="POST" class="border">
			<legend>
				<h1>Book Your Train</h1>
			</legend>
			<div class="elem-group inlined">
				<label for="email">Your E-mail</label>
				<form:input type="email" path="email" id="email" />
			</div>
			<div class="elem-group inlined">
				<label for="phone">Your Password</label>
				<form:input type="password" id="password" path="password"/>
			</div>
			<button type="submit">Login</button>
			<br>
			<a href="/forgot_password">Forgot your password?</a>
		</form:form>
	</div>
</body>
<script type="text/javascript">
	var currentDateTime = new Date();
	var year = currentDateTime.getFullYear();
	var month = (currentDateTime.getMonth() + 1);
	var date = (currentDateTime.getDate() + 1);

	if (date < 10) {
		date = '0' + date;
	}
	if (month < 10) {
		month = '0' + month;
	}

	var dateTomorrow = year + "-" + month + "-" + date;
	var checkinElem = document.querySelector("#checkin-date");
	var checkoutElem = document.querySelector("#checkout-date");

	checkinElem.setAttribute("min", dateTomorrow);

	checkinElem.onchange = function() {
		checkoutElem.setAttribute("min", this.value);
	}
	
	
	//button
	const btnEl = document.querySelector("btn");

	btnEl.addEventListener("mouseover", (event) => {
	  const x = event.pageX - btnEl.offsetLeft;
	  const y = event.pageY - btnEl.offsetTop;

	  btnEl.style.setProperty("--xPos", x + "px");
	  btnEl.style.setProperty("--yPos", y + "px");
	});
</script>
</html>