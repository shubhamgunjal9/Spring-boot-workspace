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
							<h4>Monthly Customer Report</h4>
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
								action="generateMonthlyReport.html" role="form"
								target="_blank">
								
								<div class="form-group">
									<label for="Room Number">Area</label> <span style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" id="Area" name="Area"
											style="width: 200px;" required>
											<option id="" value="">Select area</option>
											<c:forEach items="${areaTypeList}" var="at">
												<option value="${at.value}">${at.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="clientContactNo">Select Month</label><span
										style="color: red;">*</span>
									<div style="width: 200px;">
										<select class="form-control" style="width: 200px;"
											name="month" required id="mmm" >
											<option value="">--Select Month--</option>
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
									<label for="clientContactNo">Enter Year</label>
									<!-- <span style="color:red;">*</span> -->
									<div style="width: 200px;">
										<input type="text" class="form-control"
											name="year" value="2020"/>
									</div>
								</div>
								<center>
									<button type="submit" class="btn btn-skyBlue"
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