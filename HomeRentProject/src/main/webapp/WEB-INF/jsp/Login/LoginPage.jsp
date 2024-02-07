<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset= utf-8>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

* {
  box-sizing: border-box;
}
/* Position text in the middle of the page/image */
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/opacity/see-through */
  color: white; /* (255,165,0) */
  font-weight: bold;
  border: 1.5px solid #f1f1f1;
  position: absolute;
  top: 58%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 35%;
  padding: 40px;
  padding-top : 1px;
  text-align: center;
  border-radius: 50px 0 50px 0px;
}

.Name {
  background-color: rgb(255,165,0); /* Fallback color */
  background-color: rgba(255,165,0,0.8); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 1px solid #f1f1f1;
  position: absolute;
  top: 10%;
  left: 15%;
  transform: translate(-10%, -10%);
  z-index: 4;
  width: 85%;
  padding: 10px;
  text-align: center;
  border-radius: 10px 10px 10px 10px;
}
.example{
	background-image: url('img/homePage/home3.jpg');
	background-position:center;
	background-repeat:no-repeat;
	background-size:cover;
	height:620px;
	width:1342px;
	filter: blur(5px);
   -webkit-filter: blur(5px);
    margin-top : 10px;
    margin-left: -90px;
    margin-top: -52px;
    margin-bottom: -25px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="example"></div>
<div class="Name">
<h1 style="font-size:50px">Sumjai Niwas</h1>
<!-- <h3 style="font-size:20px">Jay Maharashtra Chaowk,Bhosari, Pune - 39 </h3>
 -->
 </div>
<div class="bg-text">
  <h1 style="font-size:50px">Login</h1>
   <form action="HomePage.html" method="post" accept-charset="UTF-8" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="UserName" name="userName" type="text" required value="Dhananjay Jadhav44">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" required><!-- value="Dj291181"  -->
                                </div>
                                <button type="submit" class="btn btn-lg btn-skyBlue btn-block">Sign In</button>
                            </fieldset>
                            <br>
                            <p class="text-white">${Message}</p>
                        </form>
</div>
  <%--   <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-banner text-center">
                    <h1><i class=""></i> Home Rent</h1>
                </div>
                <h3><span id=" " style="color:red;"> ${Message} </span></h3> 
                <div class="portlet portlet-skyBlue">
                    <div class="portlet-heading login-heading">
                        <div class="portlet-title">
                            <h4><strong>Login </strong> </h4>
                            
                        </div><br>
                       
                           
                        <div class="clearfix"></div>
                    </div>
                    <div class="portlet-body">
                        <form action="HomePage.html" method="post" accept-charset="UTF-8" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="UserName" name="userName" type="text" value="admin">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="admin">
                                </div>
                                <button type="submit" class="btn btn-lg btn-skyBlue btn-block">Sign In</button>
                            </fieldset>
                            <br>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> --%>

    <!-- GLOBAL SCRIPTS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <!-- HISRC Retina Images -->
    <script src="js/plugins/hisrc/hisrc.js"></script>

    <!-- PAGE LEVEL PLUGIN SCRIPTS -->

    <!-- THEME SCRIPTS -->
    <script src="js/flex.js"></script>

</body>

</html>