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
	/* auto complete */
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
							<h4>Customer Wise Report</h4>
						</div>
						<div class="portlet-widgets">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#inlineFormExample"><i class="fa fa-chevron-down"></i></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="inlineFormExample" class="panel-collapse collapse in">
						<div class="portlet-body">

<%-- 							<spring:url value="generateCustomerWiseReport.html" var="save" target="_blank"/>
 --%>
							<form class="form-inline" action="generateCustomerWiseReport.html" role="form" target="_blank" >
								


								<div class="form-group">
									<label for="clientContactNo">Customer Name</label>
								 <span style="color:red;">*</span> 
									<div style="width: 200px;">
										<input type="text" class="form-control" id="cName" placeholder="Enter Customer Name"
											name="cName" required pattren="[a-z A-Z]" />
									</div>
								</div>



								<center>
									<button type="submit" class="btn btn-skyBlue" name="save"
										id="save">Get Report</button>

									
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