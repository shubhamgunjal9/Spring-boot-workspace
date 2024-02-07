<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Download your tickit</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav>
	<img src="/images/train-logo-3.png">
	<ul>
		<li><a href="/" id="nav1">Home</a></li>
		<li><a href="#" id="nav1">About-us</a></li> 
		<li><a href="#" id="nav1">Contact-us</a></li>
		<li><a href="/login" id="nav1">Login</a></li>
		<li><a href="/register" id="nav1">Register</a></li>
		 </ul>
	</nav>
<div class="ticket">
	<div class="left">
		<div class="image">
			<p class="admit-one">
				<span>ENJOY </span>
				<span>YOUR</span>
				<span>JOURNEY..</span>
			</p>
			<div class="ticket-number">
				<p>
					#20030220
				</p>
			</div>
		</div>
		<div class="ticket-info">
			<p class="date">
				<span></span>
				<span style="font-size: 15px;">Indian RailWay</span>
				<span></span>
			</p>
			<div class="show-name">
				<h1>IRCTC Official</h1>
				<h2>${booking.name}</h2>
			</div>
			<div class="time">
				<p>${booking.checkInDate }</p>
				<p>DOORS <span>@</span> 7:00 PM</p>
			</div>
			<p class="location"><span>${booking.fromLocation }</span>
				<span class="separator"><i class="far fa-smile"></i></span><span>${booking.toLocation}</span>
			</p>
		</div>
	</div>
	<div class="right">
		<p class="admit-one">
			<span>HAVE</span>
			<span>A NICE</span>
			<span>DAY</span>
		</p>
		<div class="right-info-container">
			<div class="show-name">
				<h1>IRCTC Official</h1>
			</div>
			<div class="time">
				<p>8:00 PM <span>TO</span> 11:00 PM</p>
				<p>DOORS <span>@</span> 7:00 PM</p>
			</div>
			<div class="barcode">
				<img src="/qrcodes/${booking.email}QRCODE.png" alt="QR code">
			</div>
			<p class="ticket-number">
				#20030220
			</p>
		</div>
	</div>
	<br>
	<br>
	<button><a href="/send">send your ticket to mail</a></button>
</div>
</body>
</html>