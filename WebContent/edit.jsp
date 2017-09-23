<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
				<li><a href="index.jsp">Home</a></li>
				<li><a href="Controller?action=table_view">Table</a></li>
				<li><a href="Controller?action=list_view">List</a></li>

			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			<li class="breadcrumb-item"><a
				href="Controller?action=table_view">Employees</a></li>
			<li class="breadcrumb-item">${emp_name }</li>
		</ol>
		<div class="row">
			<c:set var="string1" value="${emp_name }" />
			<c:set var="string2" value="${fn:toUpperCase(string1)}" />
			<div class="col-md-6 text-left">
				<h1>${string2}[EMPLOYEE]</h1>
			</div>

		</div>
		<hr>
		<form class="form-horizontal"
			action="Controller?action=update&emp_name=${emp_name }&emp_designation=${emp_designation}&emp_manager=${emp_manager}"
			method="post">

			<div class="form-group">
				<label class="control-label col-sm-4">Name</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" value="${emp_name}"
						name="name" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Designation</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" value="${emp_designation}"
						name="designation" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4">Manager</label>
				<div class="col-sm-6">
					<select name="manager" class="form-control">
						<option>${emp_manager}</option>
						<c:forEach var="result" items="${manager_list}">

							<option>${result}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<input type="submit" class="btn btn-lg btn-primary" value="Submit">
				</div>
			</div>
		</form>

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