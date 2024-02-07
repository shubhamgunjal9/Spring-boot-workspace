<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- PACE LOAD BAR PLUGIN - This creates the subtle load bar effect at the top of the page. -->
      
</head>

<body>

    <div id="wrapper">

        <!-- begin TOP NAVIGATION -->
        <nav class="navbar-top" role="navigation">

            <!-- begin BRAND HEADING -->
            <div class="navbar-header ">
					<strong class="img-responsive" style="color: white;font-size: 22px;margin-left: 25px;">Medical Store</strong>
                <!-- <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".sidebar-collapse">
                    <i class="fa fa-bars"></i> Menu
                </button> -->
                <div class="navbar-brand">
                    <a href="index-2.html">
                        <img src="<%=request.getContextPath()%>img/flex-admin-logo.png" data-1x="img/flex-admin-logo@1x.png" data-2x="img/flex-admin-logo@2x.png" class="hisrc img-responsive" alt="">
                    </a>
                </div>
            </div>
            <!-- end BRAND HEADING -->

            <div class="nav-top">

                <!-- <!-- begin LEFT SIDE WIDGETS 
                <ul class="nav navbar-left">
                    <li class="tooltip-sidebar-toggle">
                        <a href="#" id="sidebar-toggle" data-toggle="tooltip" data-placement="right" title="Sidebar Toggle">
                            <i class="fa fa-bars"></i>
                        </a>
                    </li>
                    You may add more widgets here using <li>
                </ul> -->
                    <!-- begin TASKS DROPDOWN -->
				<ul class="nav navbar-right">
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-user"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                           <!--  <li>
                                <a href="profile.htm">
                                    <i class="fa fa-user"></i> My Profile
                                </a>
                            </li> -->
                            
                            <li>
                                <a class="logout_open" href="LoginPage.htm">
                                    <i class="fa fa-user"></i> Logout
                                   <!--  <strong>John Smith</strong> -->
                                </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-menu -->
                    </li>
                    <!-- /.dropdown -->
                    <!-- end USER ACTIONS DROPDOWN -->

                </ul>
                <!-- /.nav -->
                <!-- end MESSAGES/ALERTS/TASKS/USER ACTIONS DROPDOWNS -->

            </div>
            <!-- /.nav-top -->
        </nav>
        <!-- /.navbar-top -->
        <!-- end TOP NAVIGATION -->
		</div>
   
	<!-- <div id="logout">
        <div class="logout-message">
            <img class="img-circle img-logout" src="img/profile-pic.jpg" alt="">
            <h3>
                <i class="fa fa-sign-out text-green"></i> Ready to go?
            </h3>
            <p>Select "Logout" below if you are ready<br> to end your current session.</p>
            <ul class="list-inline">
                <li>
                    <a href="LogoutPage.htm" class="btn btn-green">
                        <strong>Logout</strong>
                    </a>
                </li>
                <li>
                    <button class="logout_close btn btn-green">Cancel</button>
                </li>
            </ul>
        </div>
    </div> -->
   

</body>


<!-- Mirrored from themes.startbootstrap.com/flex-admin-v1.2/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 16 Dec 2016 12:27:16 GMT -->
</html> --%>