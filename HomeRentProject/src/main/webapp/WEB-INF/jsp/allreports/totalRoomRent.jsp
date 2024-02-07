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
		$('#JoinDate').datepicker({

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
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- Inline Form Example -->

			<div class="col-lg-12">
				<div class="portlet portlet-skyBlue">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4>Total Rent of Room Report</h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">


							<form class="form-inline"
								action="generateTotalRoomRentReport.html" role="form"
								target="_blank">


								<div class="form-group">
									<label for="Room Number">Room Number</label> <span
										style="color: red;">*</span>
									<div style="width: 200px;">

										<select class="form-control" id="roomId" name="roomId"
											style="width: 200px;" required>
											<option id="" value="">Select room</option>
											<c:forEach items="${roomTypeList}" var="rl">
												<option value="${rl.value}">${rl.value}</option>

											</c:forEach>
										</select>
									</div>
								</div>
								<center>
									<button type="submit" class="btn btn-skyBlue" name="save"
										id="save">Submit</button>
								</center>

								<br>
							</form>

						</div>
					</div>
				</div>
			</div>



		</div>
	</div>


</body>
</html>