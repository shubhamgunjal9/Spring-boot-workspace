<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- New date -->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>    
<script type="text/javascript">
       $(function() {
               $("#fromDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
               $("#toDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
               $("#currentDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
               $("#cPaidDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
               
       });

   </script>  
<title>Insert title here</title>
<!-- PAGE LEVEL PLUGIN STYLES  for datepicker-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link
	href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css">
<style type="text/css">

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 80px;
}

.modal-title {
	font-size: 25px;
}
/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	border: 2px solid #888;
	border-radius: 10px 10px 10px 10px;
	width: 690px;
	height: 450px;
	margin-top: -30px;
	margin-left: -20px;
}
/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}
</style>
<script>
	function myFunction() {
		var month = new Array();
		month[0] = "January";
		month[1] = "February";
		month[2] = "March";
		month[3] = "April";
		month[4] = "May";
		month[5] = "June";
		month[6] = "July";
		month[7] = "August";
		month[8] = "September";
		month[9] = "October";
		month[10] = "November";
		month[11] = "December";

		var d = new Date();
		var n = "Pay Monthly Rent For New Month";
		var m = "Pay Remanining Room Rent";
		document.getElementById("month").innerHTML = n;
		document.getElementById("uMonth").innerHTML = m;
	}
</script>


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#cName')
								.autocomplete(
										{
											source : '${pageContext.request.contextPath}/searchCustomerName.html'
										});
						/* auto end */
					});

	//json 
	$(document).ready(function() {

		$("#cName").change(function() {

			var cName = $("#cName").val();

			/* alert(cName) */
			$.getJSON('getCustomerDetails.html', {
				cName : cName

			}).done(function(data) {
				$("#cId").val(data[0].cId);
				$("#JoinDate").val(data[0].joinDate);
				$("#roomNo").val(data[0].roomNo);
				$("#roomRent").val(data[0].roomRent);
				if (data[0].current_meter == null) {
					$("#meter").val(data[0].meter);
				} else {
					$("#meter").val(data[0].current_meter);
				}
				if (data[0].balance == null) {
					$("#balance").val(0.0);
				} else {
					$("#balance").val(data[0].balance);
				}
				$("#status").val(data[0].status);
				//alert("Last Rent Paid Months is "+data[0].month+" year "+data[0].year);
				$("#tempMonth").val(data[0].month);
				$("#tempYear").val(data[0].year);
			});

		});
	});

	
	//date picker	
/* 
	$(document).ready(function() {	
		$('#fromDate').datepicker({
			dateFormate: 'dd/mm/yy'
		});
		
		$('#toDate').datepicker({
			dateFormate: 'dd/mm/yy'
		});
	}); */
</script>
<%-- <script>
   $('#toDate').datepicker({
    dateFormat: 'dd/mm/yy'
});
</script>
<script>
   $('#fromDate').datepicker({
    dateFormat: 'dd/mm/yy'
});
</script> --%>

</head>
<body onload="myFunction()">
<input type="hidden" class="form-control" id="tempMonth" />
<input type="hidden" class="form-control" id="tempYear" />
	<div id="page-wrapper">
		<div class="page-content">
			<!-- begin PAGE TITLE ROW -->
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<!-- <h1>Dealer Details</h1> -->
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- Inline Form Example -->

			<div class="col-lg-12">
				<div class="portlet portlet-skyBlue">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4 id="month"></h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">

							<form class="form-inline" action="saveRent.html"
								name="mobilenumbervalidation" role="form"
								onsubmit="return(validate());">
								
								<input type="hidden" class="form-control" id="rId" name="rId" />
								<input type="hidden" class="form-control" id="cId" name="cId" />
								<input type="hidden" class="form-control" name="status" id="status" />

								<div class="form-group">
									<label for="clientContactNo">CustomerName</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cName" onchange="onCNameChange()"
											name="cName" required pattren="[a-z A-Z]" onclick="getDate()"
											placeholder="Enter Customer Name" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Room Number</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="roomNo" placeholder="Room Number"
											name="roomNo" required readonly="true" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">From Date</label><span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" 
											name="fromDate" required id="fromDate" onchange="onFromDateChange()"
											placeholder="Select From Date" disabled/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">To Date</label><span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control"  onchange="onToDateChange()"
											name="toDate" required id="toDate"
											placeholder="Select To Date" disabled/>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Select Month</label><span
										style="color: red;">*</span>
									<div style="width: 200px;">
									    <select class="form-control" style="width: 200px;" onchange="onMonthSelectChange()"
									    name="month" required id="mMonth" disabled>
									       <option value="">----Select Month----</option>
									       <option value="January">January</option>
									       <option value="February">February</option>
									       <option value="March">March</option>
									       <option value="April">April</option>
									       <option value="May">May</option>
									       <option value="June">June</option>
									       <option value="July">July</option>
									       <option value="August">August</option>
									       <option value="September">September</option>
									       <option value="October">October</option>
									       <option value="November">November</option>
									       <option value="December">December</option>
									    </select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Enter Year</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" onchange="onYearChange()" id="cyear"
											name="year" required placeholder="Eg: 2020" disabled/>
									</div>
								</div>
								
								
								

								<div class="form-group">
									<label for="clientContactNo">Room Rent</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="roomRent" placeholder="Room Rent"
											name="roomRent" required pattren="[a-zA-Z0-9]" readonly />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Meter Reading</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="meter"
											name="meter" required pattren="[0-9]"
											placeholder="Meter Reading" disabled/>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Current Reading</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="current_meter" disabled
											name="current_meter" required pattren="[0-9]"
											 placeholder="Current Meter" onchange="onCurrentReadingChange()" />
									</div>
								</div>


								<div class="form-group">
									<label for="clientContactNo">Used Unit</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 98px;">
										<input type="text" class="form-control" id="usedUnit"
											required pattren="[0-9]"
											placeholder="Used Unit" disabled/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Unit Price</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width:98px;">
										<input type="text" class="form-control" id="unitPrice" onchange="onUnitPriceChange()"
											name="unitPrice" required pattren="[0-9]"
											placeholder="Unit Price" disabled/>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Light Bill</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="lightBill"
											name="lightBill" required pattren="[0-9]" readonly="true"
											value="0.0" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Total = Rent + LightBill</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="total"
											name="total" required pattren="[0-9]" value="0.0"
											readonly="true" />
									</div>
								</div>
								
								 <div class="form-group">
									<label for="clientContactNo">Rent Paid</label>
									<span style="color:red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="r_paid" name="r_paid" 
										required pattren="[0-9]" disabled
											placeholder="Enter Rent Amoount" onchange="calculateRent()" />
									</div>
								</div> 

								<%-- <div class="form-group">
									<label for="clientContactNo">Rent Paid</label>
									 <span style="color:red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="r_remaining" placeholder="Remaining Rent"
											name="r_remaining" required pattren="[0-9]" readonly="true" />
									</div>
								</div> --%>
								
								<div class="form-group">
									<label for="clientContactNo">Rent Remaining</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="r_remaining" placeholder="Remaining Rent"
											name="r_remaining" required pattren="[0-9]" readonly="true" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Balance</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="balance"
											name="balance" required pattren="[0-9]" readonly value="0.0"
											onchange="bala()" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Paid Date</label><span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" onchange="onCurrentDateChange()"
											name="date" required id="currentDate" 
											placeholder="Select Paid Date" disabled/>
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="clientContactNo">Remark</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<textarea class="form-control" id="description" rows="1"
											name="description" required
											disabled></textarea>
									</div>
								</div>
								
								<center>
									<button type="submit" class="btn btn-skyBlue"
										name="assignSiteSubmit" id="save">Submit</button>
								</center>

								<br>
							</form>


						</div>
					</div>
				</div>
			</div>

			<!--  Display customer logic ------------------------------------>
			<div class="row">

				<div class="col-lg-12">

					<div class="portlet portlet-skyBlue">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Monthly Rent Details and Repayment for Same Month</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table id="example-table"
									class="table table-striped table-bordered table-hover table-skyBlue">
									<thead>
										<tr class="gradeU text-center">
											<th style="display: none;">Sr. No</th>
											<th>Customer Name</th>
											<th>Room Number</th>
											<th>From Date</th>
											<th>To Date</th>
											<th>Month</th>
											<th>Paid Date</th>
											
											<th>Room Rent</th>
											<th>Light Bill</th>
											<th>Total</th>											
											<th>Paid</th>
											<th>Remaning</th>
											<th>Balance</th>
											<th>Recieved By</th>
											
											<th style="display: none;">1</th>
											<th style="display: none;">2</th>
											<th style="display: none;">3</th>
											<th style="display: none;">4</th>
											<th style="display: none;">5</th>
											<th style="display: none;">6</th>

										</tr>
									</thead>

									<tbody id="fetchCustomer">
										<c:forEach var="rentInfo" items="${listofCustomerRent}">
											<tr
												onclick="document.getElementById('Update').style.display='block'">
												<!-- onclick="showData(this);" -->
												<td style="display: none;"><c:out value="${rentInfo.rId}"></c:out></td>
												<td><c:out value="${rentInfo.cName}"></c:out></td>
												<td><c:out value="${rentInfo.roomNo}"></c:out></td>
												<td><c:out value="${rentInfo.fromDate}"></c:out></td>
												<td><c:out value="${rentInfo.toDate}"></c:out></td>
												<td><c:out value="${rentInfo.month}"></c:out></td>
												<td><c:out value="${rentInfo.date}"></c:out></td>
												<td><c:out value="${rentInfo.roomRent}"></c:out></td>
												<td><c:out value="${rentInfo.lightBill}"></c:out></td>
												<td><c:out value="${rentInfo.total}"></c:out></td>
												<td><c:out value="${rentInfo.r_paid}"></c:out></td>
												<td><c:out value="${rentInfo.r_remaining}"></c:out></td>												
												<td><c:out value="${rentInfo.balance}"></c:out></td>
												<td><c:out value="${rentInfo.description}"></c:out></td>
												
												<td style="display: none;"><c:out value="${rentInfo.meter}"></c:out></td>
												<td style="display: none;"><c:out value="${rentInfo.current_meter}"></c:out></td>
												<td style="display: none;"><c:out value="${rentInfo.unitPrice}"></c:out></td>
												<td style="display: none;"><c:out value="${rentInfo.status}"></c:out></td>
												<td style="display: none;"><c:out value="${rentInfo.cId}"></c:out></td>
												<td style="display: none;"><c:out value="${rentInfo.year}"></c:out></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.portlet-body -->
					</div>
					<!-- /.portlet -->
				</div>
			</div>

		</div>
	</div>
	<script>
		// Get the modal
		$("#fetchCustomer tr").click(function() {
			$("#cIdUpdate").val($(this).find("td").eq(0).text());
			$("#cNameUpdate").val($(this).find("td").eq(1).text());
			$("#cRoomNo").val($(this).find("td").eq(2).text());
			$("#cFromDate").val($(this).find("td").eq(3).text());
			$("#cToDate").val($(this).find("td").eq(4).text());
			$("#cMonth").val($(this).find("td").eq(5).text());
			$("#cDate").val($(this).find("td").eq(6).text());
			$("#cRoomRent").val($(this).find("td").eq(7).text());
			$("#cLightBill").val($(this).find("td").eq(8).text());
			$("#cRentTotal").val($(this).find("td").eq(9).text());
			$("#cRoomPaid").val($(this).find("td").eq(10).text());
			$("#cRoomRemaning").val($(this).find("td").eq(11).text());			
			$("#cBalance").val($(this).find("td").eq(12).text());
			$("#cDecription").val($(this).find("td").eq(13).text());
			
			$("#cMeter").val($(this).find("td").eq(14).text());
			$("#cCurrent_meter").val($(this).find("td").eq(15).text());
			$("#cUnitPrice").val($(this).find("td").eq(16).text());
			$("#cStatus").val($(this).find("td").eq(17).text());
			$("#cCId").val($(this).find("td").eq(18).text());
		    $("#cYear").val($(this).find("td").eq(19).text());
		});
		var modal = document.getElementById('Update');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

	<!-- The Modal -->
	<div class="modal" id="Update">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header bg-black text-white">
					<h4 class="modal-title">
						<b id="uMonth"></b>
					</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<form class="modal-content animate" action="SameMonthRentEntery.html"
						method="post">
						<div class="imgcontainer"></div>
						<div class="container">
							<br>
							<table class="tttt">
								<tr>
									<td class="text-center"><label><b>Name :</b></label></td>
									<td><input class="form-control" type="text"
										name="cName" id="cNameUpdate" Readonly class="col-sm-9"></td>
										
									<td></td>
									
									<td class="text-center"><label><b>Month :</b></label></td>
									
									<td><input class="form-control" type="text"
										name="month" id=cMonth Readonly class="col-sm-9"></td>
									
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
									<td class="text-center"><label><b>Date :</b></label></td>
									<td><input class="form-control" type="text"
										name="date" id="cPaidDate" required
										class="col-sm-9" ></td>
									
										
									<td><br></td>
									
									<td class="text-center"><label><b>Room No :</b></label></td>
									
									<td><input class="form-control" type="text"
										name="roomNo" id=cRoomNo Readonly class="col-sm-9"></td>
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
									<td class="text-center"><label><b>Room Rent :</b></label></td>

									<td><input class="form-control" type="text"
										name="roomRent" id="cRoomRent" class="col-sm-9" Readonly></td>
									<td><br></td>
									
									<td class="text-center"><label><b>Light Bill :</b></label></td>

									<td><input class="form-control" type="text"
										name="lightBill" id="cLightBill" class="col-sm-9" Readonly></td>
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
								
								    <td class="text-center"><label><b>Total :</b></label></td>

									<td><input class="form-control" type="text"
										name="total" id="cRentTotal" class="col-sm-9" Readonly></td>
									
									<td><br></td>
									
									<td class="text-center"><label><b>Rent Paid :</b></label></td>

									<td><input class="form-control" type="text" 
										name="r_paid" id="cRoomPaid" class="col-sm-9" readonly></td>
									
									
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
								
									<td class="text-center"><label><b>R_Remaining
												:</b></label></td>

									<td><input class="form-control" type="text"
										name="r_remaining" id="cRoomRemaning" class="col-sm-9"
										Readonly></td>
									
									<td><br></td>
									<td class="text-center"><label><b>Balance :</b></label></td>

									<td><input class="form-control" type="text"
										name="balance" id="cBalance" class="col-sm-9" Readonly></td>
									
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
									<td class="text-center"><label><b>Now Pay :</b></label></td>

									<td><input class="form-control" type="text" onchange="calculateRentSameMonth()"
										 id="cNowPay" class="col-sm-9"></td>
									<td><br></td>
									<td class="text-center"><label><b>Description :</b></label></td>

									<td><input class="form-control" type="text" name="description"
										 id="" class="col-sm-9"></td>
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
									<td><input type="hidden" class="form-control" id="cMeter" name="meter" />
										 <input type="hidden" class="form-control" id="cCurrent_meter" name="current_meter" /> 
										<input type="hidden" class="form-control" name="unitPrice" id="cUnitPrice" /> 
										<input type="hidden" class="form-control" id="cStatus" name="status" /> 
										<input type="hidden" class="form-control" name="cId" id="cCId" />
										<input type="hidden" class="form-control" name="fromDate" id="cFromDate" />
										<input type="hidden" class="form-control" name="toDate" id="cToDate" />
									   <input type="hidden" class="form-control" name="year" id="cYear" />
									   
									   <td><button type="submit" name="SameMonthRent" id="btnPayRent" disabled
											onclick="document.getElementById('Update').style.display='none'"
											class="form-control btn btn-xs btn-success">Pay Rent</button></td>
									<td></td>
									<td><button
											onclick="document.getElementById('Update').style.display='none'"
											type="button" class="form-control btn btn-danger"
											data-dismiss="modal">Close</button></td>
								</tr>
							</table>
							<br>
							<br>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function onCNameChange(){
			document.getElementById("fromDate").disabled = false;
		}
	</script>
		<script type="text/javascript">
		function onFromDateChange(){
			document.getElementById("toDate").disabled = false;
		}
	</script>
	<script type="text/javascript">
		function onToDateChange(){
			document.getElementById("mMonth").disabled = false;
		}
	</script>
	<script type="text/javascript">
		function onCurrentDateChange(){
			document.getElementById("current_meter").disabled = false;
		}
	</script>
	<script type="text/javascript">
		function onMonthSelectChange(){
			
			document.getElementById("cyear").disabled = false;
		}
	</script>
	<script>
		function onCurrentReadingChange(){
			var meter = parseFloat(document.getElementById("meter").value);
			var currentMeter = parseFloat(document.getElementById("current_meter").value);
			if(meter > currentMeter){
				alert("Plz... Enter Current Meter Greter than Meter...");
				 document.getElementById('current_meter').value = "";
			}
			else{
				document.getElementById("usedUnit").value = (currentMeter-meter);
			}
			document.getElementById("unitPrice").disabled = false;
		}
	</script>
	
	<script type="text/javascript">
			function onYearChange(){
				document.getElementById("current_meter").disabled = false;
			}
	</script>
	<script>
		function getDate() {
			var todaydate = new Date();
			var day = todaydate.getDate();
			var month = todaydate.getMonth() + 1;
			var year = todaydate.getFullYear();
			var datestring = day + "-" + month + "-" + year;
			//document.getElementById("currentDate").value = datestring;
			/* document.getElementById("fromDate").value = datestring;
			document.getElementById("toDate").value = datestring; */
			document.getElementById("year").value = year;
			
			var month = new Array();
			month[0] = "January";
			month[1] = "February";
			month[2] = "March";
			month[3] = "April";
			month[4] = "May";
			month[5] = "June";
			month[6] = "July";
			month[7] = "August";
			month[8] = "September";
			month[9] = "October";
			month[10] = "November";
			month[11] = "December";

			var d = new Date();
			var nn = month[d.getMonth()];
			//document.getElementById("mmm").value = nn;
		}
	</script>

	<script type="text/javascript">
		function calculateRent() {
			var RoomRent = parseFloat(document.getElementById("total").value);
			var PaidRent = parseFloat(document.getElementById("r_paid").value);
			var Balance = parseFloat(document.getElementById("balance").value);
			
			document.getElementById("description").disabled = false;

			
				if (PaidRent > RoomRent) {
					Balance = ((parseFloat(Balance)) + (parseFloat(RoomRent)))
							- (parseFloat(PaidRent));
					document.getElementById("balance").value = Balance;
					document.getElementById("r_remaining").value = 0;
				} else if ((PaidRent <= RoomRent) && (Balance > 0)) {
					var RemainingRent = (parseInt(RoomRent)) - (parseInt(PaidRent));
					$("#r_remaining").val(RemainingRent.toFixed());
					Balance = (parseInt(Balance)) + (parseInt(RemainingRent));
					//alert("Balance : " + Balance);
					$("#balance").val(Balance);
				} else {
					Balance = 0;
					var RemainingRent = (parseInt(RoomRent)) - (parseInt(PaidRent));
					$("#r_remaining").val(RemainingRent.toFixed());
					Balance = (parseInt(Balance)) + (parseInt(RemainingRent));
					//alert("Balance : " + Balance);
					$("#balance").val(Balance);
				}
				//document.getElementById("r_paid").disabled = true;
				document.getElementById("currentDate").disabled = false;
		}
	</script>

 <!-- Calculations for 2nd time pay in same month -->	
	<script type="text/javascript">
		function calculateRentSameMonth() {
			
			var cRoomRemaning = parseFloat(document.getElementById("cRoomRemaning").value);
			var cNowPay = parseFloat(document.getElementById("cNowPay").value);
			var cBalance = parseFloat(document.getElementById("cBalance").value);
			var cRentTotal = parseFloat(document.getElementById("cRentTotal").value);
			var cRoomPaid = parseFloat(document.getElementById("cRoomPaid").value);
			
			document.getElementById("btnPayRent").disabled = false;
			document.getElementById("cNowPay").disabled = true;
			
			if((cNowPay<cRoomRemaning)&&(cBalance>0)){                                                                    
				/* alert("1st"); */
				cRoomRemaning=cRoomRemaning-cNowPay;
				$("#cRoomRemaning").val(cRoomRemaning.toFixed());
				
				cBalance=cBalance-cNowPay;
				$("#cBalance").val(cBalance.toFixed());
				
				/* cRentTotal=cNowPay;
				$("#cRentTotal").val(cRentTotal.toFixed()); */
				
				cRoomPaid = cRoomPaid + cNowPay;
				$("#cRoomPaid").val(cRoomPaid.toFixed());
			}
			else if((cNowPay >= cRoomRemaning)&&(cBalance>0)){
				/* alert("2nd"); */
				cRoomRemaning=0;
				$("#cRoomRemaning").val(cRoomRemaning.toFixed());
				
				cBalance=cBalance-cNowPay;
				$("#cBalance").val(cBalance.toFixed());
				
				/* cRentTotal=cNowPay;
				$("#cRentTotal").val(cRentTotal.toFixed());	 */
				
				cRoomPaid = cRoomPaid + cNowPay;
				$("#cRoomPaid").val(cRoomPaid.toFixed());
			}
		}
	</script> 

	<script type="text/javascript">
		function onUnitPriceChange() {
			var unitPrice = parseFloat(document.getElementById("unitPrice").value);
			var usedUnit = parseFloat(document.getElementById("usedUnit").value);
			var roomRent = parseFloat(document.getElementById("roomRent").value);
			document.getElementById("r_paid").disabled = false;
			
			var lightBill = (usedUnit) * (Math.round(unitPrice));
			document.getElementById("lightBill").value = lightBill;
			var finalTotal = lightBill + roomRent;
			document.getElementById("total").value = finalTotal;
			}
	</script>
	<script type="text/javascript">
		function onMonthChange(){
			var month = document.getElementById("mMonth").value;
			var tempMonth = document.getElementById("tempMonth").value;
			var tempYear = document.getElementById("tempYear").value;
			var year = document.getElementById("year").value;
			//alert("month "+month+" tempMonth "+tempMonth+" tempYear "+tempYear+" year "+year)
			if((month==tempMonth)&&(year==tempYear)){
				alert("You Have Already Paid Rent of "+month+" Month For Repayment for Same Month Plz click on Table Data Below");
				document.getElementById('mMonth').value = "";
			}
		}
	</script>
	
</body>
</html>