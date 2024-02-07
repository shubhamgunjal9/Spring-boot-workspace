<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register your account</title>
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
		<li><a href="/register" id="nav1">Register</a></li>
		 </ul>
	</nav>
	<div id="id1">
		<form:form action="regsuccess" modelAttribute="registration" method="POST" class="border">
		<legend><h1>Register your account</h1></legend>
			<div class="elem-group">
				<label for="name">Your Name</label> <form:input type="text" path="username" id="name"
					name="visitor_name" placeholder="Shubham Gunjal" />
			</div>
			<div class="elem-group">
				<label for="password">Password</label> <form:input type="password" id="password" path="password" />
			</div>
			<div class="elem-group">
				<label for="email">Your E-mail</label> <form:input type="email" path="email"
					id="email" name="visitor_email"
					placeholder="shubham.gunjal@email.com" />
			</div>
			<div class="elem-group inlined">
				<label for="phone">Your Phone</label> <form:input type="tel" id="phone" path="contact"
					name="visitor_phone" placeholder="+91 8208090110" />
			</div>
			<div class="elem-group inlined">
				<label for="text">Address</label> <form:input type="text" id="add" path="address" />
			</div>
			<div class="elem-group inlined">
				<label for="marital-status">marital status:</label> <form:select name="maritalstatus" id="maritalstatus" path="maritalStatus">
					<option value="married">Married</option>
					<option value="un-married">un-married</option>
				</form:select>
			</div>
			<div class="elem-group inlined">
				<label for="gender">gender:</label> <form:select name="gender" id="gender" path="gender">
					<option value="male">male</option>
					<option value="female">female</option>
					<option value="transgender">transgender</option>
				</form:select>
			</div>
			<div class="elem-group inlined">
				<label for="checkin-date">date of Birth</label> <form:input type="date"
					id="dob" path="dateofbirth" name="dob"  />
			</div>
			<button type="submit" >register</button>
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