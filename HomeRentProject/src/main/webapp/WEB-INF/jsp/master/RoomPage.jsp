<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<script type="text/javascript">
	var showData = function($this) {
		$("#update").show();
		/* $("#delete").show(); */
		$("#save").hide();
		$("#roomId").val($($this).find("td").eq(0).text());
		$("#roomNo").val($($this).find("td").eq(1).text());
		$("#RoomRent").val($($this).find("td").eq(4).text());
		//$("#Maintenance").val($($this).find("td").eq(3).text());
		$("#Area").val($($this).find("td").eq(3).text());
		$("#RoomType").val($($this).find("td").eq(2).text());

	}
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
			<h5 style="color: red;">${errorMsg}</h5>
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- Inline Form Example -->

			<div class="col-lg-12">
				<div class="portlet portlet-skyBlue">


					<div class="portlet-heading">

						<div class="portlet-title">
							<h4>Add Room</h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">

							<spring:url value="saveRooms.html" var="save" />

							<form:form class="form-inline" action="${save}" role="form"
								modelAttribute="room">
								<div style="width: 200px;">
									<input type="hidden" class="form-control" id="roomId"
										name="roomId" />
								</div>

								<div class="form-group">
									<label for="Room Number">Area</label> <span style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" id="Area" name="aId"
											style="width: 200px;" required>
											<option id="" value="">Select area</option>
											<c:forEach items="${areaTypeList}" var="at">
												<option value="${at.key}">${at.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="Room Number">Room Type</label> <span style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" id="RoomType" name="rTypeId"
											style="width: 200px;" required>
											<option id="" value="">Select Room Type</option>
											<c:forEach items="${TypeRoomList}" var="trl">
												<option value="${trl.key}">${trl.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="roomNumber">Room Number / Name</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="roomNo"
											onchange="onRoomNoChange()" name="roomNo"
											placeholder="Enter Room Number" required="required" />
									</div>
								</div>



								<div class="form-group">
									<label for="roomRent">Room Rent</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="RoomRent"
											name="RoomRent" placeholder="Enter Room Rent"
											required="required" />
									</div>
								</div>

								<!-- <div class="form-group">
							      		<label for="maintenance">Maintenance</label> <span
										style="color: red;">*</span>
									    <div style="width: 200px;">
									     	<input type="text" class="form-control" id="Maintenance"
											name="Maintenance" placeholder="Maintenance" required="required" />
									  </div>
								    </div>
 							    -->
								<center>
									<button type="submit" class="btn btn-skyBlue" name="save"
										id="save">Submit</button>

									<button type="submit" class="btn btn-skyBlue"
										name="roomMasterupdate" onclick="clickAlertUpdate()"
										style="display: none;" id="update">Update</button>
								</center>

								<br>
							</form:form>

						</div>
					</div>
				</div>
			</div>

			<!--  Display Dealer logic ------------------------------------>
			<div class="row">

				<div class="col-lg-12">

					<div class="portlet portlet-skyBlue">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Room Details</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table id="example-table"
									class="table table-striped table-bordered table-hover table-skyBlue text-center">
									<thead>
										<tr class="gradeU text-center">
											<th class="text-center">Sr No.</th>
											<th class="text-center">Room Number</th>
											<th class="text-center">Room Type</th>
											<th class="text-center">Area </th>
											<th class="text-center">Room Rent</th>
											<th class="text-center">Status</th>
											<!-- <th>Maintenance</th> -->
										</tr>
									</thead>

									<tbody id="fetchService">
										<c:forEach var="roomInfo" items="${listofRoom}">
											<tr onclick="showData(this);">
												<td><c:out value="${roomInfo.roomId}"></c:out></td>
												<td><c:out value="${roomInfo.roomNo}"></c:out></td>
												<td><c:out value="${roomInfo.typeRoom}"></c:out></td>
												<td><c:out value="${roomInfo.area}"></c:out></td>
												<td><c:out value="${roomInfo.RoomRent}"></c:out></td>
											    <td><c:out value="${roomInfo.Status}"></c:out></td>
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

	
</body>
</html>