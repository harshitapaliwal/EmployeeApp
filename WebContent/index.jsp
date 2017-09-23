<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets\css\bootstrap.min.css" rel="stylesheet">
<link href="assets\css\main.css" rel="stylesheet">
<script src="assets\js\jquery.min.js"></script>

<script src="assets\js\bootstrap.min.js"></script>

<title>NineLeaps App</title>
</head>
<body>
	<nav class="navbar navbar-background">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand " href="#"> <img class="img"
				src="assets\imgs\company_logo.png"></a>
			<button class="navbar-toggle collapsed " data-target="#mynavbar"
				data-toggle="collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-nav-collapse"
			id="mynavbar">
			<ul class="nav navbar-nav navbar-right bg-hover">
				<li class="bg-active"><a href="#">Home</a></li>
				<li><a href="Controller?action=table_view">Table</a></li>
				<li><a href="Controller?action=list_view">List</a></li>

			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<h1>CODE CHALLENGE</h1>
		<hr>

		<p class="text-muted">Please select one of the view:</p>

		<div class="row">

			<div class="col-md-4 col-md-offset-2">
				<a href="Controller?action=table_view"><button type="button"
						class="btn btn-lg btn-primary">Table View</button></a>
			</div>
			<div class="col-md-4 col-md-offset-1">
				<a href="Controller?action=list_view"><button type="button"
						class="btn btn-lg btn-primary">List View</button></a>
			</div>

		</div>

	</div>
	<hr>
	<footer>
	<div class="container">
		<div class="row">

			<div class="col-md-6">
				<p>© 2017 Nineleaps Technology Solutions</p>
				<p>
					<a href="https://nineleaps.com/privacy-policy" target="_blank">Privacy
						Policy</a>
				</p>
			</div>
			<div class="col-md-6 ">
				<a href="https://www.nineleaps.com/" target="_blank"><img
					class="img" src="assets\imgs\company_footer_logo.png"></a>
			</div>

		</div>
	</div>
	</footer>
</body>
</html>