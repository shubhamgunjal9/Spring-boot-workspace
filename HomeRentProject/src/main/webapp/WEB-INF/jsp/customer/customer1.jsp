<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- New date -->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>    
<script type="text/javascript">
       $(function() {
               $("#joinDate").datepicker({ dateFormat: "dd-mm-yy" }).val()
               $("#cLeaveDateDelete").datepicker({ dateFormat: "dd-mm-yy" }).val()
               $("#dPaidDate").datepicker({ dateFormat: "dd-mm-yy" }).val()   
               $("#cdPaidDate").datepicker({ dateFormat: "dd-mm-yy" }).val()                  
       });

   </script> 
<title></title>
<!-- PAGE LEVEL PLUGIN STYLES  for datepicker-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link
	href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#roomId").change(function() {
			var roomId = $("#roomId").val();
			//	alert(roomId)
			$.getJSON('getRoomDetails.html', {
				roomId : roomId
			}).done(function(data) {
				$("#roomRent").val(data[0].RoomRent);
				$("#cArea").val(data[0].area);
				$("#cRoomType").val(data[0].typeRoom); 
			});

		});
	});
</script>
 <script type="text/javascript">
	$(document).ready(function() {
		$("#cName").change(function() {
			var cName = $("#cName").val();
			//	alert(roomId)
			$.getJSON('getC_Details.html', {
				cName : cName
			}).done(function(data) {
				
				if((data[0].cName)==($("#cName").val()))
					{
						alert("Customer Name Aleredy Registered...");
						document.getElementById("cName").value = "";
					}
				document.getElementById("otherCustomers").disabled = false;
				 document.getElementById("cContact").disabled = false; 
			});document.getElementById("otherCustomers").disabled = false;
			 document.getElementById("cContact").disabled = false; 

		});
	});
</script> 
</head>
<body>
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
			<h5 style="color: red;">${error1}</h5>
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- Inline Form Example -->

			<div class="col-lg-12">
				<div class="portlet portlet-skyBlue">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4>New Customer Registration</h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">

							<form class="form-inline" action="saveCustomer.html"
								name="mobilenumbervalidation" role="form"
								onsubmit="return(validate());">
								<input type="hidden" class="form-control" id="cId" name="cId" />
								<input type="hidden" id="leaveDate" name="leaveDate" /> <input
									type="hidden" id="returnD" name="returnD" />

								<div class="form-group">
									<label for="clientContactNo">Enter Customer Full Name</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cName"
											onclick="getDate()" name="cName"
											onchange="onCustomerChange()"
											placeholder="Enter Full Name" required pattren="[a-z A-Z]" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Other Customers</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<textarea class="form-control" id="otherCustomers" rows="1" disabled
											name="otherCustomers" placeholder="Enter Other Customers"></textarea>
									</div>
								</div>
								

								<div class="form-group">
									<label for="clientContactNo">Customer Mobile</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cContact" disabled
											name="cContact" placeholder="Enter Mobile Number 1" required
											pattren="[7-9][0-9]{10}" onchange="onContactChange()"/>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Alternative Mobile</label>
									<%-- <span style="color:red;">*</span> --%>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cContact2" disabled
											name="cContact2" placeholder="Enter Mobile Number 2" 
											pattren="[7-9][0-9]{10}" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Aadhar Number</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="adharNo"
											onchange="onAdharNoChange()" name="adharNo"
											placeholder="Enter Adhar No" required pattren="[0-9]"
											disabled />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Customer Address</label>
									 <span style="color:red;">*</span> 
									<div style="width: 200px;">
										<textarea class="form-control" id="cAddress" rows="1" disabled onchange="onAddressChange()"
											name="cAddress" placeholder="Enter Customer Address" required></textarea>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">PAN Number</label> 
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cPAN" name="cPAN"
											onchange="onPanChange()" placeholder="Enter PAN No" 
											pattren="[0-9]" disabled/>
									</div>
								</div>

								<div class="form-group">
									<label for="Room Number">Room Number</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" id="roomId" name="roomId"
											disabled style="width: 200px;" onchange="onRoomNoChange()"
											required>
											<option id="" value="">Select room</option>
											<c:forEach items="${roomTypeList}" var="rl">
												<option value="${rl.key}">${rl.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Room Rent</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="roomRent"
											name="roomRent" required pattren="[a-zA-Z0-9]"
											readonly="true" placeholder="Room Rent"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Area</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cArea"
											name="cArea" required pattren="[a-zA-Z0-9]"
											readonly="true" placeholder="Room Rent"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Room Type</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cRoomType"
											name="cRoomType" required pattren="[a-zA-Z0-9]"
											readonly="true" placeholder="Room Rent"/>
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Deposit</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="deposite" onchange="onDepositeChange()"
											name="deposite" placeholder="Deposite" required disabled
											pattren="[0-9]" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Deposit Paid</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="d_paid" disabled onchange="onD_PaidChange()"
											name="d_paid" placeholder="D_Paid" required pattren="[0-9]" />
									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Deposit Remaining</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control" id="d_remaining"
											name="d_remaining" required pattren="[0-9]" value="0.0"
											readonly="true"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="clientContactNo">Deposit Paid Date</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" ng-model="startTime" class="form-control"
											 id="dPaidDate" name="dPaidDate" disabled
											placeholder="Date" required />

									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Join Date</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" ng-model="startTime" class="form-control"
											 id="joinDate" name="joinDate" disabled
											placeholder="Date" required />

									</div>
								</div>

								<div class="form-group">
									<label for="clientContactNo">Meter Reading</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="meter" disabled
											name="meter" placeholder="Meter Reading" required
											pattren="[0-9]" />
									</div>
								</div>
								
								<%-- <div class="form-group">
									<label for="Room Number">Room Number</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" id="roomId" name="roomId"
											 style="width: 200px;" onchange="onRoomNoChange()">
											<option id="" value="">Select room</option>
											<c:forEach var="rl" items="${roomTypeList}"> <!-- From Room List -->
											   <c:forEach var="customerInfo" items="${listofCustomer}">  <!-- From Customer -->
													
														<option value="${rl.key}">${rl.value}</option>
													
											   </c:forEach>
											</c:forEach>
										</select>
									</div>
								</div> --%>
								
								<center>
									<button type="submit" class="btn btn-skyBlue"
										name="assignSiteSubmit" id="save">Submit</button>

									<!-- <button type="submit" class="btn btn-skyBlue"
										name="customerupdate" onclick="clickAlertUpdate()"
										style="display: none;" id="update">Pay</button>

									<button type="submit" class="btn btn-skyBlue"
										name="customerdelete" onclick="clickAlertUpdate()"
										style="display: none;" id="delete">Delete</button> -->
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
								<h4>Customer Details</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table id="example-table"
									class="table table-striped table-bordered table-hover table-skyBlue">
									<thead>
										<tr class="gradeU">
											<th style="display: none;">Id</th>
											<th style="width:150px;">Name</th>
											<th>Mobile</th>
											<th style="display: none;">Mobile 2</th>
											<th style="display: none;">Aadhar No</th>
											<th style="display: none;">PAN No</th>
											<th style="display: none;">Address</th>
											<th style="width:100px;">Room NO</th>
											<th>Rent</th>
											<th>Deposite</th>
											<th>Deposite Paid</th>
											<th>Deposite Balance</th>
											
											<th>JoinDate</th>
											<th style="display: none;">Leave Date</th>
											<th style="display: none;">meter</th>
											<th style="display: none;">Status</th>
											<th style="display: none;">ReturnD</th>
											<th style="display: none;">roomId</th>
											<th style="display: none;">other Customers</th>
											<th>Area</th>
											<th>Room Type</th>
											<th>Deposite Paid Date</th>
										</tr>
									</thead>

									<tbody id="fetchCustomer">
										<c:forEach var="customerInfo" items="${listofCustomer}">
											<tr
												onclick="document.getElementById('Update').style.display='block'">
												<td style="display: none;"><c:out
														value="${customerInfo.cId}"></c:out></td>
												<td><c:out value="${customerInfo.cName}"></c:out></td>
												<td><c:out value="${customerInfo.cContact}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.cContact2}"></c:out></td>
												<td style="display: none;"><c:out value="${customerInfo.adharNo}"></c:out></td>
												<td style="display: none;"><c:out value="${customerInfo.cPAN}"></c:out></td>
												<td style="display: none;"><c:out value="${customerInfo.cAddress}"></c:out></td>
												<td><c:out value="${customerInfo.roomNo}"></c:out></td>
												<td><c:out value="${customerInfo.roomRent}"></c:out></td>
												<td><c:out value="${customerInfo.deposite}"></c:out></td>
												<td><c:out value="${customerInfo.d_paid}"></c:out></td>
												<td><c:out value="${customerInfo.d_remaining}"></c:out></td>
												
												<td><c:out value="${customerInfo.joinDate}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.leaveDate}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.meter}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.status}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.returnD}"></c:out></td>
												<td style="display: none;"><c:out 
														value="${customerInfo.roomId}"></c:out></td>
												<td style="display: none;"><c:out
														value="${customerInfo.otherCustomers}"></c:out></td>
												<td><c:out 
														value="${customerInfo.cArea}"></c:out></td>
												<td><c:out
														value="${customerInfo.cRoomType}"></c:out></td>
												<td><c:out value="${customerInfo.dPaidDate}"></c:out></td>		
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		// Get the modal
		$("#fetchCustomer tr").click(function() {
			$("#cIdUpdate").val($(this).find("td").eq(0).text());
			$("#cNameUpdate").val($(this).find("td").eq(1).text());
			$("#cMobileUpdate").val($(this).find("td").eq(2).text());
			$("#cMobileUpdate2").val($(this).find("td").eq(3).text());
			$("#cAdharUpdate").val($(this).find("td").eq(4).text());
			$("#cPanUpdate").val($(this).find("td").eq(5).text());
			$("#cAddressUpdate").val($(this).find("td").eq(6).text());
			$("#cRoomNoUpdate").val($(this).find("td").eq(7).text());
			$("#cRoomRentUpdate").val($(this).find("td").eq(8).text());
			$("#cDepositeUpdate").val($(this).find("td").eq(9).text());
			$("#cD_Paid").val($(this).find("td").eq(10).text());
			$("#cD_Remaining").val($(this).find("td").eq(11).text());
			$("#cJoinDate").val($(this).find("td").eq(12).text());
			$("#cLeaveDateUpdate").val($(this).find("td").eq(13).text());
			$("#cMeter").val($(this).find("td").eq(14).text());
			$("#cStatus").val($(this).find("td").eq(15).text());
			$("#cReturnD").val($(this).find("td").eq(16).text());
			$("#cRoomIdUpdate").val($(this).find("td").eq(17).text());
			$("#otherCustomerUpdate").val($(this).find("td").eq(18).text());
			$("#cAreaUpdate").val($(this).find("td").eq(19).text());
			$("#cRoomTypeUpdate").val($(this).find("td").eq(20).text());

			$("#cIdDelete").val($(this).find("td").eq(0).text());
			$("#cNameDelete").val($(this).find("td").eq(1).text());
			$("#cMobileDelete").val($(this).find("td").eq(2).text());
			$("#cMobileDelete2").val($(this).find("td").eq(3).text());
			$("#cAdharDelete").val($(this).find("td").eq(4).text());
			$("#cPanDelete").val($(this).find("td").eq(5).text());
			$("#cAddressDelete").val($(this).find("td").eq(6).text());
			$("#cRoomNoDelete").val($(this).find("td").eq(7).text());
			$("#cRoomRentDelete").val($(this).find("td").eq(8).text());
			$("#cDepositeDelete").val($(this).find("td").eq(9).text());
			$("#cD_PaidDelete").val($(this).find("td").eq(10).text());
			$("#cD_RemainingDelete").val($(this).find("td").eq(11).text());
			$("#cJoinDateDelete").val($(this).find("td").eq(12).text());
			$("#cLeaveDateDelete").val($(this).find("td").eq(13).text());
			$("#cMeterDelete").val($(this).find("td").eq(14).text());
			$("#cStatusDelete").val($(this).find("td").eq(15).text());
			$("#cReturnDelete").val($(this).find("td").eq(16).text());
			$("#otherCustomerDelete ").val($(this).find("td").eq(17).text());
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
		<div class="modal-dialog modal-xl">
			<div class="modal-content">

				<!-- Modal Header -->
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#home"
						style="width: 200px; margin-left: 10px; background-color: #888; color: #fff;">Update
							Customer Details</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#menu1"
						style="width: 200px; margin-left: 10px; background-color: #888; color: #fff;"
						onclick="getDateForLeave()">Delete Customer</a></li>
				</ul>

				<!-- Modal body -->
				<!-- Tab panes -->
				<div class="tab-content">
					<div id="home" class="container-fluid tab-pane active">
						<br>
						<form action="updateCustomer.html">
							<table class="table table-borderless">
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Name:</label> <input type="text"
												class="form-control" id="cNameUpdate" name="cName">
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Mobile:</label> <input type="text"
												class="form-control" id="cMobileUpdate" name="cContact">
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Mobile 2:</label> <input type="text"
												class="form-control" id="cMobileUpdate2" name="cContact2">
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Aadhar No:</label> <input type="text"
												class="form-control" id="cAdharUpdate" name="adharNo"
												readonly>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Address:</label> <input type="text"
												class="form-control" id="cAddressUpdate" name="cAddress"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Join Date:</label> <input type="text"
												class="form-control" id="cJoinDate" name="joinDate" readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Room Number:</label> <select onchange="onRoomNoUpdateChange()"
												class="form-control" id="roomIdUpdate" name="roomId"
												style="width: px;" required>
												<option id="" value="">Select room</option>
												<c:forEach items="${roomTypeList}" var="rl">
													<option value="${rl.key}">${rl.value}</option>
												</c:forEach>
											</select>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Room Rent:</label> <input type="text"
												class="form-control" id="cRoomRentUpdate" name="roomRent"
												readonly>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Deposite:</label> <input type="text"
												class="form-control" id="cDepositeUpdate" name="deposite"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Deposit Paid:</label> <input type="text"
												class="form-control" id="cD_Paid" name="d_paid" readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Remaining:</label> <input type="text"
												class="form-control" id="cD_Remaining" name="d_remaining"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Now Pay:</label> <input type="text"
												class="form-control" id="cD_NowPay"
												onchange="calculateDeposite()">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Area:</label> <input type="text"
												class="form-control" id="cAreaUpdate" name="cArea"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Room Type:</label> <input type="text"
												class="form-control" id="cRoomTypeUpdate" name="cRoomType" readonly>
										</div>
									</td>
									
									<td>
										<div class="form-group">
											<label for="usr">Deposit Paid Date:</label> <input type="text"
												class="form-control" id="cdPaidDate" name="dPaidDate" placeholder="Date">
										</div>
									</td>
								</tr>
							</table>
							<input type="hidden" id="cPanUpdate" name="cPAN" /> <input
								type="hidden" id="cIdUpdate" name="cId" /> <input type="hidden"
								id="cLeaveDateUpdate" name="leaveDate" /> <input type="hidden"
								id="cMeter" name="meter" /> <input type="hidden" id="cStatus"
								name="status" /> <input type="hidden" id="cReturnD"
								name="returnD" /><input type="hidden" id=otherCustomerUpdate
								name="otherCustomers" />
								<input type="hidden" id="cRoomIdUpdate">
								
							<button type="submit" class="btn btn-primary" id="btnUpdate"
								style="width: 280px; margin-left: 10px;" name="updateCustomer"
								disabled>Update Customer Details</button>
						</form>
					</div>
					<!-- Delete Customer Code -->
					<div id="menu1" class="container-fluid tab-pane fade">
						<br>
						<form action="customerdelete.html">
							<table class="table table-borderless">
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Name:</label> <input type="text"
												class="form-control" id="cNameDelete" name="cName" readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Mobile:</label> <input type="text"
												class="form-control" id="cMobileDelete" name="cContact"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Mobile 2:</label> <input type="text"
												class="form-control" id="cMobileDelete2" name="cContact2"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Aadhar No:</label> <input type="text"
												class="form-control" id="cAdharDelete" name="adharNo"
												readonly>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">Room Number:</label> <input type="text"
												class="form-control" id="cRoomNoDelete" name="roomIdDel"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Room Rent:</label> <input type="text"
												class="form-control" id="cRoomRentDelete" name="roomRent"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Deposite:</label> <input type="text"
												class="form-control" id="cDepositeDelete" name="deposite"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">D Paid:</label> <input type="text"
												class="form-control" id="cD_PaidDelete" name="d_paid"
												readonly>
										</div>
									</td>

								</tr>
								<tr>
									<td>
										<div class="form-group">
											<label for="usr">D Remaining:</label> <input type="text"
												class="form-control" id="cD_RemainingDelete"
												name="d_remaining" readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Join Date:</label> <input type="text"
												class="form-control" id="cJoinDateDelete" name="joinDate"
												readonly>
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Leave Date:</label> <input type="text"
												class="form-control" id="cLeaveDateDelete" name="leaveDate">
										</div>
									</td>
									<td>
										<div class="form-group">
											<label for="usr">Return Deposite:</label> <input type="text"
												class="form-control" id="cReturnDelete" name="returnD"
												onchange="returnDeposite()">
										</div>
									</td>
								</tr>
							</table>
							<input type="hidden" id="cIdDelete" name="cId" /> <input
								type="hidden" id="cAddressDelete" name="cAddress" /> <input
								type="hidden" id="cMeterDelete" name="meter" /> <input
								type="hidden" id="cStatusDelete" name="status" /> <input
								type="hidden" id="cPanDelete" name="cPAN" />
							<button type="submit" class="btn btn-primary" id="btnDelete"
								style="width: 280px; margin-left: 10px;" disabled>Delete
								Cutomer</button>

						</form>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button
						onclick="document.getElementById('Update').style.display='none'"
						style="width: 280px; margin-left: 10px;" type="button"
						class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<script>
		function getDate() {
			var todaydate = new Date();
			var day = todaydate.getDate();
			var month = todaydate.getMonth() + 1;
			var year = todaydate.getFullYear();
			var datestring = day + "/" + month + "/" + year;
			//document.getElementById("joinDate").value = datestring;
		}
	</script>
	<script>
		function getDateForLeave() {
			var todaydate = new Date();
			var day = todaydate.getDate();
			var month = todaydate.getMonth() + 1;
			var year = todaydate.getFullYear();
			var datestring = day + "/" + month + "/" + year;
			//document.getElementById("cLeaveDateDelete").value = datestring;
		}
	</script>
	<script>
		function calculateDeposite() {
			var cD_Paid = parseFloat(document.getElementById("cD_Paid").value);
			var cD_Remaining = parseFloat(document.getElementById("cD_Remaining").value);
			var cD_NowPay = parseFloat(document.getElementById("cD_NowPay").value);

			if (cD_NowPay <= cD_Remaining) {
				cD_Remaining = cD_Remaining - cD_NowPay;
				document.getElementById("cD_Remaining").value = cD_Remaining;
				cD_Paid = cD_Paid + cD_NowPay;
				document.getElementById("cD_Paid").value = cD_Paid;
				document.getElementById("btnUpdate").disabled = false;
			} else {
				alert("plz Enter Less Than : " + cD_Remaining + " or : "
						+ cD_Remaining);
				document.getElementById("cD_NowPay").value = "";
			}
		}
	</script>
	<script>
			function returnDeposite(){
				document.getElementById("btnDelete").disabled = false;
			}
    </script>
    <script>
    		function onContactChange(){
    			document.getElementById("adharNo").disabled = false;
    			document.getElementById("cContact2").disabled = false;
    		}
    </script>

	<script>
			function onAdharNoChange(){
				var adharNo = parseFloat(document.getElementById("adharNo").value);
				if (document.mobilenumbervalidation.adharNo.value == ""
					|| isNaN(document.mobilenumbervalidation.adharNo.value)
					|| document.mobilenumbervalidation.adharNo.value.length != 12) {
				alert("Please provide valid adhar No.");
				document.mobilenumbervalidation.adharNo.focus();
				return;
				}
				<c:forEach var="customerInfo" items="${listofCustomer}">
						if((${customerInfo.adharNo})==adharNo){
							alert("Adhar card Already Registered...");
							document.getElementById("adharNo").value = "";
							document.mobilenumbervalidation.adharNo.focus();
							return;
						}
				</c:forEach>
				
				document.getElementById("cAddress").disabled = false;
			}
	</script>

<script>
			function onPanChange(){
				var pan_no = document.getElementById("cPAN");
				 if (pan_no.value != "") {
				            PanNo = pan_no.value;
				            var panPattern = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
				            if (PanNo.search(panPattern) == -1) {
				            	alert("PAN No Pattern Not Matches");
				                pan_no.focus();
				                pan_no.value='';
				                return;
				            }
							
				        }
			}
	</script>
<script type="text/javascript">
		function onRoomNoChange(){
			var room_Id = document.getElementById("roomId").value;
			 <c:forEach var="customerInfo" items="${listofCustomer}">
			if((${customerInfo.roomId})==room_Id){
				alert("Room Already Registered...");
				document.getElementById("roomId").value = "";
				document.mobilenumbervalidation.roomId.focus();
				return;
			}
			</c:forEach>
			document.getElementById("deposite").disabled = false;
		}
</script>
	<script>
			function onAddressChange(){
				document.getElementById("roomId").disabled = false;
				document.getElementById("cPAN").disabled = false;
			}
	</script>
	<script>
			function onDepositeChange(){
				document.getElementById("d_paid").disabled = false;
			}
	</script>
	<script>
			function onD_PaidChange(){
				var TotalDeposite = $("#deposite").val();
				var AlreadyPaidDeposite = $("#d_paid").val();
				var RemainingDeposite = 0;

				RemainingDeposite = TotalDeposite - AlreadyPaidDeposite;

				$("#d_remaining").val(RemainingDeposite.toFixed());

				document.getElementById("meter").disabled = false;
				document.getElementById("joinDate").disabled = false;
				document.getElementById("dPaidDate").disabled = false;
				
			}
	</script>
	
	<script type="text/javascript">
			function onRoomNoUpdateChange(){
				var cRoomIdUpdate = $("#cRoomIdUpdate").val();
				var roomIdUpdate = $("#roomIdUpdate").val();
				if((cRoomIdUpdate)!=(roomIdUpdate)){
					alert("You Select Wrong Room No");
					document.getElementById("roomIdUpdate").value = "";
					roomIdUpdate.focus();
				}
			}
	</script>
	<script type="text/javascript">
		function onElse(){
			alert("Okk");
			document.getElementById("otherCustomers").disabled = false;
			document.getElementById("cContact").disabled = false;
		}
	</script>
	<script>
		function onCustomerChange(){
			
			document.getElementById("otherCustomers").disabled = false;
			document.getElementById("cContact").disabled = false;
		}
	</script>  
</body>

</html>