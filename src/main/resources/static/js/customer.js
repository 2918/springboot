/**
 * 
 */
$(document).ready(function(){
	
	//customer save buttion click
	$("#customersave").click(function(event){
		
		event.preventDefault();
		//Using ajax json submit.

		var data = {};
		data['customerId'] = $('#customerId').val();
		data['customerName'] = $('#customerName').val();
		data['occupation'] = $('#occupation').val();
		data['qualification'] = $('#qualification').val();
		data['doorno'] = $('#doorno').val();
		data['street'] = $('#street').val();
		data['city'] = $('#city').val();
		data['pincode'] = $('#pincode').val();
		//alert(data);
		alert(JSON.stringify(data));
		
		$.ajax({ 
			 	headers: {
			        Accept: "application/json; charset=utf-8",
			        "Content-Type": "application/json; charset=utf-8"
			    },
			    type: "POST",
			    url: "/springboot/saveCustomer",
			    data: JSON.stringify(data),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
				success : function(response) {
					if(response.validated) {
						$('#statusMessage').html(response.statusMessage);
						$('#statusMessage').addClass("alert alert-success");
					}
					else{
						$("#customeridmsg").html("");
						$("#customernamemsg").html("");
						$("#occupationmsg").html("");
		          		$("#quanlificationmsg").html("");
		          		$("#doornomsg").html("");
		          		$("#streetmsg").html("");
		          		$("#citymsg").html("");
		          		$("#pincodemsg").html("");
		          		
						$.each(response.errorMessages,function(key,value){
							console.log(key + value);
		  	          		if(key=="customerId") {
		  	          			$("#customeridmsg").html(value);
		  	          		}
		  	          		if(key=="customerName") {
		  	          			$("#customernamemsg").html(value);
		  	          		}
		  	          		if(key=="occupation") {
		  	          			$("#occupationmsg").html(value);
		  	          		}
		  	          		if(key=="qualification") {
		  	          			$("#quanlificationmsg").html(value);
		  	          		}
		  	          		if(key=="doorno") {
		  	          			$("#doornomsg").html(value);
		  	          		}
		  	          		if(key=="street") {
		  	          			$("#streetmsg").html(value);
		  	          		}
		  	          		if(key=="city") {
		  	          			$("#citymsg").html(value);
		  	          		}
		  	          		if(key=="pincode") {
		  	          			$("#pincodemsg").html(value);
		  	          		}
			             });
					}
				},
				error : function(xhr, error) {
					$('#statusMessage').html("Error while adding customer records");
					$('#statusMessage').addClass("alert alert-danger");
					console.log("Error Code :"+ xhr.status);
					console.log(error);
				}
		});
		
	});
	
	

	//reset button
	$('#reset').click(function(event){
		$('#statusMessage').html("");
		$("#customeridmsg").html("");
		$("#customernamemsg").html("");
		$("#occupationmsg").html("");
  		$("#quanlificationmsg").html("");
  		$("#doornomsg").html("");
  		$("#streetmsg").html("");
  		$("#citymsg").html("");
  		$("#pincodemsg").html("");
  		$('#statusMessage').removeClass("alert alert-danger");
  		$("#customerUpdate").prop("disabled",true);
  		
	});
	
	//view Customer form
	
	$('#viewCustomer').click(function(){
		$("#customerUpdate").prop("disabled",true);

		$.ajax({
			type : "GET",
			url : '/springboot/getCustomer',
			data : "customerId=" + $('#viewCustomerId').val(),
		    contentType: "application/json; charset=utf-8",
			success : function(response){
				if(response.validated) {
					
					$('#statusMessage').html("");
					$('#statusMessage').removeClass("alert alert-danger");
					
					$('#customerId').val(response.customerTO.customerId);
		            $("#customerId").attr("disabled", "disabled"); 
					$('#customerName').val(response.customerTO.customerName);
					$("#customerName").attr("disabled", "disabled");
					$('#occupation').val(response.customerTO.occupation);
					$('#qualification').val(response.customerTO.qualification);
					$('#addressId').val(response.customerTO.addressId);
					$('#doorno').val(response.customerTO.doorno);
					$('#city').val(response.customerTO.city);
					$('#street').val(response.customerTO.street);
					$('#pincode').val(response.customerTO.pincode);
					$("#customerUpdate").prop("disabled",false);
				}
				else{
					$('#statusMessage').html(response.statusMessage);
					$('#statusMessage').addClass("alert alert-danger");
					
					$('#customerId').val("");
		            //$("#customerId").attr("disabled", "disabled"); 
					$('#customerName').val("");
					//$("#customerName").attr("");
					$('#occupation').val("");
					$('#qualification').val("");
					$('#doorno').val("");
					$('#city').val("");
					$('#street').val("");
					$('#pincode').val("");
					$("#customerUpdate").prop("disabled",true);

				}
			},
			error : function(xhr, error){
				console.log("Error code:" + xhr.status);
				console.log(error);
			}
		});
	});

	$("#customerUpdate").click(function(event){
		
		event.preventDefault();
	
		var data = {};
		data['customerId'] = $('#customerId').val();
		data['customerName'] = $('#customerName').val();
		data['occupation'] = $('#occupation').val();
		data['qualification'] = $('#qualification').val();
		data['addressId'] = $('#addressId').val();
		data['doorno'] = $('#doorno').val();
		data['street'] = $('#street').val();
		data['city'] = $('#city').val();
		data['pincode'] = $('#pincode').val();
		$.ajax({ 
			 	headers: {
			        Accept: "application/json; charset=utf-8",
			        "Content-Type": "application/json; charset=utf-8"
			    },
			    type: "POST",
			    url: "/springboot/updateCustomer",
			    data: JSON.stringify(data),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
				success : function(response) {
					if(response.validated) {
						$('#statusMessage').html("Customer record Updated successfully");
						$('#statusMessage').addClass("alert alert-success");
					}
					else{
						$("#customeridmsg").html("");
						$("#customernamemsg").html("");
						$("#occupationmsg").html("");
		          		$("#quanlificationmsg").html("");
		          		$("#doornomsg").html("");
		          		$("#streetmsg").html("");
		          		$("#citymsg").html("");
		          		$("#pincodemsg").html("");
		          		
						$.each(response.errorMessages,function(key,value){
							console.log(key + value);
		  	          		if(key=="customerId") {
		  	          			$("#customeridmsg").html(value);
		  	          		}
		  	          		if(key=="customerName") {
		  	          			$("#customernamemsg").html(value);
		  	          		}
		  	          		if(key=="occupation") {
		  	          			$("#occupationmsg").html(value);
		  	          		}
		  	          		if(key=="qualification") {
		  	          			$("#quanlificationmsg").html(value);
		  	          		}
		  	          		if(key=="doorno") {	
		  	          			$("#doornomsg").html(value);
		  	          		}
		  	          		if(key=="street") {
		  	          			$("#streetmsg").html(value);
		  	          		}
		  	          		if(key=="city") {
		  	          			$("#citymsg").html(value);
		  	          		}
		  	          		if(key=="pincode") {
		  	          			$("#pincodemsg").html(value);
		  	          		}
			             });
					}
				},
				error : function(xhr, error) {
					$('#statusMessage').html("Error while updating customer records");
					$('#statusMessage').addClass("alert alert-danger");
					console.log("Error Code :"+ xhr.status);
					console.log(error);
				}
		});
});
});