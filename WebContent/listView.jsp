<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="bg-active"><a href="Controller?action=list_view">List</a></li>

			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			<li class="breadcrumb-item">List View</li>

		</ol>

<c:forEach var="ceolist" items="${ceo_List}">
		<ul>
			<li><a
				href="Controller?action=show&emp_name=${ceolist.name}&emp_designation=${ceolist.designation}&emp_manager=${ceolist.manager}">${ceolist.name}</a>
				${ceolist.designation} <c:forEach var="ceo_Manager_list"
					items="${ceo_Manager_List}">
					<ul>
						<li><a
							href="Controller?action=show&emp_name=${ceo_Manager_list.name}&emp_designation=${ceo_Manager_list.designation}&emp_manager=${ceo_Manager_list.manager}">${ceo_Manager_list.name}</a>
							${ceo_Manager_list.designation} <c:forEach var="emp_manager_list"
								items="${emp_List}">
								<c:choose>
									<c:when
										test="${emp_manager_list.manager == ceo_Manager_list.name}">
										<ul>
											<li><a
												href="Controller?action=show&emp_name=${emp_manager_list.name}&emp_designation=${emp_manager_list.designation}&emp_manager=${emp_manager_list.manager}">${emp_manager_list.name}</a>
												${emp_manager_list.designation} <c:forEach var="emp_list"
													items="${emp_List}">
													<c:choose>
														<c:when
															test="${emp_list.manager == emp_manager_list.name}">
															<ul>
																<li><a
																	href="Controller?action=show&emp_name=${emp_list.name}&emp_designation=${emp_list.designation}&emp_manager=${emp_list.manager}">${emp_list.name}</a>
																	${emp_list.designation} <c:forEach var="list"
																		items="${emp_List}">
																		<c:choose>
																			<c:when test="${list.manager == emp_list.name}">
																				<ul>
																					<li><a
																						href="Controller?action=show&emp_name=${list.name}&emp_designation=${list.designation}&emp_manager=${list.manager}">${list.name}</a>
																						${list.designation}</li>
																				</ul>
																			</c:when>
																		</c:choose>
																	</c:forEach></li>
															</ul>
														</c:when>
													</c:choose>
												</c:forEach></li>
										</ul>
									</c:when>
								</c:choose>
							</c:forEach></li>
					</ul>
				</c:forEach></li>
		</ul>
	</c:forEach>
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