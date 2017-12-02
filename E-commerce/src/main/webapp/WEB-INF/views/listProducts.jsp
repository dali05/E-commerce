<div class="container">
	<div class="row">
		<!-- would be to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- to display the actual products -->
		<div class="col-md-9">
			<!-- added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12  p-1">
					<c:if test="${userClickAllProducts==true}">

						<script>
							window.categorieId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">

						<script>
							window.categorieId = '${categorie.id}';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
							<li class="breadcrumb-item active">category</li>
							<li class="breadcrumb-item active">${categorie.name}</li>
						</ol>
					</c:if>

				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
				   <div class="container-fluid">
				   		<div class="table-responsive">
				   			<table border="0" id="productListTable" class="table table-hover">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>UnitPrice</th>
								<th>Quantity</th>
								<th></th>
							</tr>						
						</thead>

					</table>
				
				   		</div>
				   
				   </div>
				</div>
			</div>
		</div>
	</div>
</div>