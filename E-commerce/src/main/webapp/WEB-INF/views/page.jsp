<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Mohamed Ali Laaroussi">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>My Shop - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- DataTable bootstrap CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
   <div class="se-pre-con"></div>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Load only when user click Home -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Load only when user click about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Load only when user click Contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- Load only when user click products -->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Load only when user click products -->
			<c:if
				test="${userClickShowProduct==true}">
				<%@include file="singleProduit.jsp"%>
			</c:if>
			<!-- Load only when user click manage products -->
			<c:if
				test="${userClickManageProducts==true}">
				<%@include file="manageProduct.jsp"%>
			</c:if> 
		</div>

		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<!-- jQuery validate -->
		<script src="${js}/jquery.validate.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Data Tables plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Data Tables bootstrap script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<!-- My Js -->
		<script src="${js}/myapp.js"></script>
	</div>
	
	<script>

	$(window).on("load", function () {
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);			
			
		});
		
    </script>
	
</body>

</html>
