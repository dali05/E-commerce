<div class="container">
	<div class="row">
		<!-- would be to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<!-- to display the actual products -->
		<div class="col-md-9">
		<!-- added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12  p-1">
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
							<li class="breadcrumb-item active">All products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
							<li class="breadcrumb-item active">category</li>
							<li class="breadcrumb-item active">${categorie.name}</li>
						</ol>
					</c:if>
					
				</div>
			</div>	
		</div>
	</div>
</div>