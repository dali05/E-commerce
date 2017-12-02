$(function() {
	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProdu.se-pre-concts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#orderProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;	
	default:
		$('#a_' + menu).addClass('active');
		break;
	}
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	//----------------------
	
	// code for jquery dataTable
	 
	var $table= $('#productListTable');
	//execute the bellow code only where we have this table
	if($table.length){
		//console.log('Inside the table!');
	
		var jsonUrl = '';
		
		if(window.categorieId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot+'/json/data/categorie/'+ window.categorieId +'/product';
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
								return '<img src=' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg class="img-responsive dataTableImg"/>';
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
								if(userRole=='ADMIN'){
									str+='<a href="'+window.contextRoot+'/admin/'+data+'/product" class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></span></a>';
									
								}else{
									if(row.quantity < 1){
										str+='<a href="#" class="btn btn-success disabled"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span></a>';
										
									}else{								
										str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span></a>';
									}
								}
								return str;
							}
						}
				
						]
		});
	}
	
	//dismissing the alert after 3 seconds
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
 		},500)
	}
	
	//--------------bootbox--------------
	
	
/*--------------------------------
	data table for admin
/----------------------------------*/
	var $adminProdoctsTable= $('#productsTable');
	//execute the bellow code only where we have this table
	if($adminProdoctsTable.length){
		//console.log('Inside the table!');
	
		var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
		
		
		$adminProdoctsTable.DataTable({
			lengthMenu:[[10,30,50,-1], ['10 Records','30 Records','50 Records','ALL']],
			pageLength: 30,
			ajax: {
				url:jsonUrl,
				dataSrc:''
			},
			columns: [
				
				         {
				        	 data:'id'
					     },
						
						{
							data:'code',
							bSortable:false,
							mRender:function(data, type, row){
								return '<img src=' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg class="img-responsive adminDataTableImg"/>';
							}
						},
						{
							data:'name'
						},
						{
							data:'brand'
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
							data:'unitPrice',
							mRender: function(data, type, row){
								return data+' DT' 
							}
						},
						
						{
							data:'active',
							bSortable:false,
							mRender:function(data,type,row){
								
								var str='';
								str += '<label class="switch round">';

								if(data){
									str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';

								}else{
									str += '<input type="checkbox" value="'+row.id+'"/>';

								}
								str += '<div class="slider"></div></label>';
							     return str;
								
							}
							
							
						},
						{
							data:'id',
							bSortable:false,
							mRender:function(data,type,row){
								var str='';
								str+='<a href="'+window.contextRoot+'/admin/'+data+'/product"' ;
								str+='class="btn btn-primary">';
								str+='<i class="fa fa-pencil"></i></a>';
								return str;
							
							}
						}
				
						],
						
				   initComplete:function(){
					   var api=this.api();
					   api.$('.switch input[type="checkbox"]').on('change',function(){
					        var checkbox=$(this); 
							var checked = checkbox.prop('checked');
							var dMsg = (checked)? 'you want to enable the product?':
												  'you want to disable the product?';
							var  value = checkbox.prop('value');
							bootbox.confirm({
						    	size: 'medium',
						    	title:'Product Enable/Disable',
						    	message: dMsg,
						    	callback: function (confirmed) {
							        if (confirmed){
							        	
							        var activationUrl=window.contextRoot+'/admin/product/'+value+'/activation';
							        $.post(activationUrl,function(data){

							        	bootbox.alert({
							        	   size:'medium',
							        	   title:'Information',
							        	   message:data,
							          });
							        	
							        });
							        	
							           
							        }
							        else {							        	
							        	checkbox.prop('checked', !checked);
							        }
						    	}
							
						});
							
					});
				   }
						
		});
	}
//--------------------------
//validation code for category
	var $categoryForm = $('#categoryForm')
	if($categoryForm.length){
		
		$categoryForm.validate({
			rules:{
				name: {
					required:true,
					minlength:2
				},
				description:{
					required:true
				}
			},
			message:{
				name:{
					required:'please add the category name!',
					minlength:'the cartegory name should not be less than 2 characters',
				},
				description:{
					    required:'please add the description for this category',
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of danger
				error.addClass('text-danger');
				//add the element after the input element
				error.insertAfter(element);
			}
		});
	}
//------------------------------	
	
	//validation code for login
	var $loginForm = $('#loginForm')
	if($loginForm.length){
		
		$loginForm.validate({
			rules:{
				username: {
					required:true,
					email:true
				},
				password:{
					required:true
				}
			},
			messages:{
				username:{
					required:'Please enter the username!',
					email:'Please enter valid email address',
				},
				password:{
					    required:'please enter the password',
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of danger
				error.addClass('text-danger');
				//add the element after the input element
				error.insertAfter(element);
			}
		});
	}	
//----------------------
//handling the click event of refrech cart button
	$('button[name="refreshCart"]').click(function(){
		var cartLineId = $(this).attr('value');
		var countField = $('#count_' + cartLineId);
		var originalCount = countField.attr('value');
		// do the checking only the count has changed
		if(countField.val() !== originalCount) {	
			// check if the quantity is within the specified range
			if(countField.val() < 1 || countField.val() > 3) {
				// set the field back to the original field
				countField.val(originalCount);
				bootbox.alert({
					size: 'medium',
			    	title: 'Error',
			    	message: 'Product Count should be minimum 1 and maximum 3!'
				});
			}
			else {
				// use the window.location.href property to send the request to the server
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
				window.location.href = updateUrl;
			}
		}
	});	
	
//----------------------
	
});