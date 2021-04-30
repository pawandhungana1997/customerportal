<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="add" method="post"">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
            			Edit Customer
            		</c:if>
						<c:if test="${customer == null}">
            			Add New Customer
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id"
						value="<c:out value='${customer.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${customer.firstname}' />"
						class="form-control" name="firstname" required>
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${customer.lastname}' />"
						class="form-control" name="lastname" required>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Phone</label> <input type="tel"
						value="<c:out value='${customer.phone}' />" class="form-control"
						name="phone" required>
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${customer.email}' />" class="form-control"
						name="email" required>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>