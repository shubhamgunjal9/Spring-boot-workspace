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
	
		 $("#save").hide(); 
		 var rTid =$($this).find("td").eq(0).text();
		 document.getElementById("rTypeId").value = rTid;
		 var TypeRoom =$($this).find("td").eq(1).text();
		 document.getElementById("typeRoom").value = TypeRoom;
		
	
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
	<%-- 		<h5 style="color: red;">${errorMsg}</h5> --%>
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- Inline Form Example -->

			<div class="col-lg-12">
				<div class="portlet portlet-skyBlue">
				
				
					<div class="portlet-heading">
					
						<div class="portlet-title">
							<h4>Add Room Type</h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">

							<spring:url value="saveRoomType.html" var="save" />

							<form:form class="form-inline" action="${save}" role="form"
								modelAttribute="roomT">
								<div style="width: 200px;">
									<input type="hidden" class="form-control" id="rTypeId"
										name="rTypeId" />
								</div>
								<div class="form-group">
									<label for="roomNumber">Room Type</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<input type="text" class="form-control" id="typeRoom" 
											name="typeRoom" placeholder="Type Room" required="required"/>
									</div>
								</div>
								
								
								
								<center>
									<button type="submit" class="btn btn-skyBlue" name="save"
										id="save">Submit</button>

									<button type="submit" class="btn btn-skyBlue"
										name="roomTypeUpdate" onclick="clickAlertUpdate()"
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
								<h4>Room Type Details</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table id="example-table"
									class="table table-striped table-bordered table-hover table-skyBlue">
									<thead>
										<tr class="gradeU">
											<th>Sr No.</th>
											<th>Room Type</th>
										</tr>
									</thead>

									<tbody id="fetchService">
										<c:forEach var="roomTypeInfo" items="${listofRoomType}">
											<tr onclick="showData(this);">
												<td><c:out value="${roomTypeInfo.rTypeId}"></c:out></td>
												<td><c:out value="${roomTypeInfo.typeRoom}"></c:out></td>
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