<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<style>
.dropdown-item{
   color: white;
}
.dropdown-item:focus, .dropdown-item:hover, .dropdown-item a :hover {
    color: black;
    background-color: #e9ecef;}
 .badge{
 	    border-radius: 1.25rem;
 }   
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top ">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">My Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse " id="navbarResponsive">
			<ul class="navbar-nav navbar-toggler-right">
				<li id="about" class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li id="contact" class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
				<li id="manageProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/admin/products">Manage Products</a></li>
				<li id="orderProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/admin/order">Order</a></li>
				</security:authorize>
			</ul>
			<ul class="navbar-nav ml-auto">
			<security:authorize access="hasAuthority('USER')">
					<li id="login" class="nav-item">
					   <a class="nav-link" href="${contextRoot }/cart/show">
					   	   <span class="fa fa-shopping-cart fa-lg"></span>
					       <span class="badge badge-primary">${userModel.cart.cartLines }</span>&nbsp;&nbsp;${userModel.cart.grandTotal} dt
					   </a>
					</li>
					</security:authorize>
			<security:authorize access="isAnonymous()">
				<li id="register" class="nav-item"><a class="nav-link"
					href="${contextRoot}/register">Sing Up</a></li>
				<li id="login" class="nav-item"><a class="nav-link"
					href="${contextRoot}/login">Login</a></li>
					
						
			</security:authorize>
			<security:authorize access="isAuthenticated()">		
				<li class="nav-item dropdown" id="userCart">
				   <a class="nav-link dropdown-toggle" href="#" id="dropdownMenu1"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					 ${userModel.fullName}
					 <span class="caret"></span></a>
					
					<div class="dropdown-menu bg-dark"aria-labelledby="navbarDropdown">
					
						<a class="dropdown-item" href="${contextRoot}/perform-logout">Logout</a>
					</div>
				</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
	window.userRole='${userModel.role}'
</script>
