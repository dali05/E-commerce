<h1 class="my-4">Category</h1>
<div class="list-group">
	<c:forEach items="${categories}" var="categorie">
		<a href="${contextRoot}/show/categorie/${categorie.id}/products" class="list-group-item" id="a_${categorie.name}">${categorie.name}</a>
	</c:forEach>
</div>