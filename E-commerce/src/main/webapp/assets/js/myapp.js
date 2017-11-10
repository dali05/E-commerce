$(function() {
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable
	 
	var $table= $('#productListTable');
	//execute the bellow code only where we have this table
	if($table.length){
		//console.log('Inside the table!');
	
		var jsonUrl = '';
		
		if(window.categorieId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot+'/json/data/categorie/'+ window.categorieId +'/products';
		}
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1], ['3 Records','5 Records','10 Records','ALL']],
			pageLength: 5,
			ajax: {
				url:jsonUrl,
				dataSrc:''
			},
			columns: [
					
						
						{
							data:'code',
							mRender:function(data, type, row){
								return '<img class="img-responsive dataTableImg" src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
							}
						},
						{
							data:'name'
						},
						{
							data:'brand'
						},
						{
							data:'unitPrice',
							mRender: function(data, type, row){
								return data+' DT' 
							}
						},
						{
							data:'quantity',
							mRender: function(data,type,row){
								
								if(data < 1){
									return '<span style="color:red"> Out of stock</span>';
								}
								return data;
								
							}
						},
						{
							data:'id',
							bSortable:false,
							mRender: function(data, type, row){
								var str='';
								str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye aria-hidden="true"></i></a> &#160;';
								
								if(row.quantity < 1){
									str+='<a href="#" class="btn btn-success disabled"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span></a>';
									return str;
								}else{
									str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span></a>';
									return str;
								}
							}
						}
				
						]
		});
	}
		
})