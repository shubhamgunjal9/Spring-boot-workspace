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
			<li><a href="/login" id="nav1">Login</a></li>
			<li><a href="register" id="nav1">Register</a></li>
		</ul>
	</nav>
	<div id="id1">
		<form:form action="/BookTicket" modelAttribute="booking" method="POST"
			class="border">
			<legend>
				<h1>Book Your Train</h1>
			</legend>
			<div class="elem-group">
				<label for="name">Your Name</label>
				<form:input type="text" path="name" id="name" name="visitor_name"
					placeholder="Shubham Gunjal" />
			</div>
			<div class="elem-group inlined">
				<label for="email">Your E-mail</label>
				<form:input type="email" path="email" id="email"
					name="visitor_email" placeholder="shubham.gunjal@email.com" />
			</div>
			<div class="elem-group inlined">
				<label for="phone">Your Phone</label>
				<form:input type="tel" id="phone" path="contact"
					name="visitor_phone" placeholder="+91 8208090110" />
			</div>
			<hr>
			<div class="elem-group inlined">
				<div class="dropdown-menu">
					<label for="From">From:</label>
					<form:select name="From" id="From" path="fromLocation">
						<option value="Mumbai">Mumbai</option>
						<option value="Pune">Pune</option>
						<option value="AhilyaNagar">Ahilyanagar</option>
						<option value="Vambori">Vambori</option>
					</form:select>
				</div>
			</div>
			<div id="swap" class="swipe_icn"> </div>
			<div class="elem-group inlined">
				<div class="dropdown-menu">
					<label for="To">To:</label>
					<form:select name="To" id="To" path="toLocation">
						<option value="Mumbai">Mumbai</option>
						<option value="Pune">Pune</option>
						<option value="AhilyaNagar">Ahilyanagar</option>
						<option value="Vambori">Vambori</option>
					</form:select>
				</div>
			</div>
			<hr>
			<div class="elem-group inlined">
				<label for="persons">Persons</label>
				<form:input type="number" id="person" name="total_person"
					placeholder="count" path="count" />
			</div>

			<div class="elem-group inlined">
				<label for="checkin-date">Check-in Date</label>
				<form:input type="date" id="checkin-date" path="checkInDate"
					name="checkin" />
			</div>
			<div class="elem-group inlined">
				<label for="train-class-selection">train_preference</label>
				<form:select id="train-class-selection" path="trainPreferences"
					name="train_preference">
					<option value="">choose a train preference</option>
					<option value="Anubhuti-class">Anubhuti class</option>
					<option value="Visdome-AC">Visdome AC</option>
					<option value="AC-First-Class">AC First Class</option>
					<option value="sleeper">sleeper</option>
					<option value="Second-sitting">seccond sitting</option>
				</form:select>
			</div>
			<div class="elem-group inlined">
				<label for="catogory">Catogory</label>
				<form:select id="catogary" path="passengerCatagory" name="catogory">
					<option value="">choose a person catogory</option>
					<option value="general">general</option>
					<option value="ladies">ladies</option>
					<option value="Lower_Birth">lower birth</option>
					<option value="disable">person with disability</option>
				</form:select>
			</div>
			<hr>
			<button type="submit">book
				<!-- <a href="/success">book</a> -->
			</button>
		</form:form>
	</div>
	<div class="details">
		<h1>
			this is <span>IRCTC Official Website</span>
		</h1>

		<p>
			Have you not found the right one?<br> Find a service suitable
			for you here.
		</p>

		<a href="https://www.google.com/">INFORMATION</a>
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
	  btnEl.style.setProperty("--yPos",�y�+�"px");
	});
</script>
</html>