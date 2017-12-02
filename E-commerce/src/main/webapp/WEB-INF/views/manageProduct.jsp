<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<style>
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
<div class="container">
	<div class="row">
		
		<c:if test="${not empty message}">
			<div class="col-lg-12">
				<div class="alert alert-success">
					<button class="close" data-dismiss="alert">&times;</button>
					
					${message}
					
				</div>
			</div>
		</c:if>
		<c:if test="${not empty message2}">
			<div class="col-lg-12">
				<div class="alert alert-warning">
					<button class="close" data-dismiss="alert">&times;</button>
					
					${message2}
					
				</div>
			</div>
		</c:if>
		
		<div class="col-lg-8 offset-lg-2">
			<div class="card">
				<div class="card-header text-white bg-primary mb-3">
					<h4>product Managment</h4>
				</div>
				<div class="card-body">
					<!-- Form Elements -->
					<sf:form modelAttribute="products" action="${contextRoot}/admin/products" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label for="name">Enter product Name:</label>
							<sf:input class="form-control" type="text" path="name" id="name"
								placeholder="product Name" />
							<sf:errors path="name" cssClass="text-danger" element="em"></sf:errors>	
						</div>
						<div class="form-group">
							<label for="brand">Enter brand Name:</label>
							<sf:input class="form-control" type="text" path="brand"
								id="brand" placeholder="brand name" />
							<sf:errors path="brand" cssClass="text-danger" element="em"></sf:errors>
						</div>
						<div class="form-group">
							<label for="description">Enter Description:</label>
							<sf:textarea class="form-control" type="text" path="description"
								rows="4" id="description" placeholder="write a description" />
						</div>
						<div class="form-group">
							<label for="unitPrice">Enter Unit Price:</label>
							<sf:input class="form-control" type="number" path="unitPrice"
								id="unitPrice" placeholder="unitPrice" />
							<sf:errors path="unitPrice" cssClass="text-danger" element="em"></sf:errors>	
						</div>
						<div class="form-group">
							<label for="quantity">Enter Quantity:</label>
							<sf:input class="form-control" type="number" path="quantity"
								id="quantity" placeholder="quantity" />
							<sf:errors path="quantity" cssClass="text-danger" element="em"></sf:errors>	
						</div>
						<div class="form-group">	
						<label>photo</label>
						<sf:input type="file" path="file" class="form-control"/>
						<sf:errors path="file" cssClass="text-danger" element="em"></sf:errors>
					</div>
						<div class="form-group">
							<label for="categoryId">Select category:</label>
							<sf:select class="form-control" id="categoryId" path="categoryId"
								items="${categories}" itemLabel="name" itemValue="id" />
							
							    <div class="text-right">
							    	</br>
							    <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add category</button>
							    </div>
						
						</div>
						<div class="form-group">
							<input class="btn btn-primary" type="submit" name="submit"
								id="submit" />
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
						</div>
					</sf:form>
					
				</div>
			</div>
		</div>
	</div>
<div class="row">
	<div class="col-lg-12">
		<h3>Available products</h3>
		<hr/>
	</div>
	<div class="col-lg-12">
		<div class="container-fluid">
			<div class="table-responsive">
				<table id="productsTable" class="table table-condensed table-bordered">
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>	
			</table>
	
			</div>
		
		</div>
		<!-- product table for admin -->
			
	</div>
</div>
<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
	        <div class="text-left">
	        <h4 class="modal-title" style="margin-left: -472px" id="myModalLabel">New Category</h4>
	        </div>
	      </div>
	      <div class="modal-body">
	        	
	        <sf:form id="categoryForm" class="form-horizontal"
	                modelAttribute="category" action="${contextRoot}/admin/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	        	        
	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>	        
	        </sf:form>
	      </div>
	    </div>
	  </div>
	</div>

</div>