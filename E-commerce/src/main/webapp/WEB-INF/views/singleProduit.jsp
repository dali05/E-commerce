<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-lg-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active breadcrumb-item">${produit.name}</li>
			</ol>
		</div>
	</div>
</div>

<div class="row">
	<!-- display the product image -->
	<div class="col-lg-4">
		<div class="thumbnail">
			<img src="${images}/${produit.code}.jpg" class="img-fluid" />
		</div>
	</div>
	<!-- display the product discription -->
	<div class="col-lg-8">
		<h3>${produit.name}</h3>
		<hr />
		<p>${produit.description}</p>
		<hr />
		<h4>
			price: <strong>${produit.unitPrice} dt</strong>
		</h4>
		<hr />


		<c:choose>
			<c:when test="${produit.quantity<1}">
				<h6>
					Qte.Available: <span style="color:red;">Out Of Stock</span>
				</h6>
			</c:when>
			<c:otherwise>
				<h6>Qte.Available: ${produit.quantity}</h6>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${produit.quantity<1}">
					<a href="#"class="btn btn-success disabled"><strike>
					<i class="fa fa-shopping-cart"></i>Addto cart</strike></a>
			</c:when>
			<c:otherwise>
				<a href="${contextRoot}/cart/add/${produit.id}/product"
					class="btn btn-success"> <i class="fa fa-shopping-cart"></i>Add
					to cart
				</a>
			</c:otherwise>
		</c:choose>


		<a href="${contextRoot}/show/all/products" class="btn btn-success">Back
		</a>
	</div>
</div>