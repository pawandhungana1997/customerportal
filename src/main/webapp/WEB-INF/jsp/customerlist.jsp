<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Portal</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #53354a">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand"> Customer Portal </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h2 class="text-center">Customer Portal</h2>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-primary">Add
					Customer</a>
			</div>
			<br>
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customerList}">

						<tr>
							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.firstname}" /></td>
							<td><c:out value="${customer.lastname}" /></td>
							<td><c:out value="${customer.phone}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td><a href="edit?id=<c:out value='${customer.id}' />"><button type="button" class="btn btn-warning">Edit</button></a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${customer.id}' />"><button type="button" class="btn btn-danger">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>

	</div>
</body>
</html>