<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>My Shop - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- DataTable bootstrap CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">


</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">My Shop</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->
    
		<div class="container">
				<!-- this will be disabled if the credentials are wrong -->
				<c:if test="${not empty message}">
					<div class="row">
                        <div class="offset-md-3 col-md-6">
                        	<div class="alert bg-danger mt-5" style="color: white;">${message}</div>
                        </div>
                    </div>    
				</c:if>
				<!-- this will be disabled only when user has logged out -->
				<c:if test="${not empty logout}">
					<div class="row">
                        <div class="offset-md-3 col-md-6">
                        	<div class="alert alert-success mt-5">${logout}</div>
                        </div>
                    </div>    
				</c:if>
				
			<div class="row">

				<div class="offset-md-3 col-md-6">

					<div class="card"  style="margin-top: 10%;">

						<div class="card-heading bg-primary">
							<h4>Login</h4>
						</div>

						<div class="card-body">
							<form action="${contextRoot}/login" method="POST"
								 id="loginForm">
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Email:
									</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										 <input type="submit" value="Login"
											class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
									</div>
								</div>
							</form>

						</div>
						<div class="panel-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>

					</div>

				</div>

			</div>

		</div>



		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<!-- jQuery validate -->
		<script src="${js}/jquery.validate.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- My Js -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
