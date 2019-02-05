
$(document).ready(function(){

	//Load Customer details..	
	$.ajax({
		type : "GET",
		url : "getCustomers",
		contentType : "application/json",
		success : function(customersTO) {
			
				console.log(customersTO);
				$.each(customersTO, function(index, customerTO) {
					var option = new Option(customerTO.customerName, customerTO.customerId);
					$('#customerName').append(option);
				});
		},
		error : function(xhr, error){
			console.log(error);
		}
		
	});
	
	//submit issue policy form
	$('#issuePolicy').click(function(event){
		
		event.preventDefault();
		var data = {};
		data['customerId'] = $('#customerName').val();
		data['policyno'] = $('#policyno').val();
		data['premium'] = $('#premium').val();
		data['issueDate'] = $('#issueDate').val();
		data['nextPremiumDate'] = $('#nextPremiumDate').val();
		data['policyTerm'] = $('#policyTerm').val();

		$.ajax({ 
			 	headers: {
			        Accept: "application/json; charset=utf-8",
			        "Content-Type": "application/json; charset=utf-8"
			    },
			    type: "POST",
			    url: "issuePolicy",
			    data: JSON.stringify(data),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
				success : function(response) {
					if(response.validated) {
						$('#statusMessage').html("Policy Issued successfully");
						$('#statusMessage').addClass("alert alert-success");
					}
					else{
						$("#customernamemsg").html("");
						$("#policynomsg").html("");
						$("#premiummsg").html("");
		          		$("#issuedatemsg").html("");
		          		$("#nextpremiumdatemsg").html("");
		          		$("#policytermmsg").html("");
		          		
						$.each(response.errorMessages,function(key,value){
							console.log(key + value);
		  	          		if(key=="customerName") {
		  	          			$("#customernamemsg").html(value);
		  	          		}
		  	          		if(key=="policyno") {
		  	          			$("#policynomsg").html(value);
		  	          		}
		  	          		if(key=="premium") {
		  	          			$("#premiummsg").html(value);
		  	          		}
		  	          		if(key=="issueDate") {
		  	          			$("#issuedatemsg").html(value);
		  	          		}
		  	          		if(key=="nextPremiumDate") {
		  	          			$("#nextpremiumdatemsg").html(value);
		  	          		}
		  	          		if(key=="policyTerm") {
		  	          			$("#policytermmsg").html(value);
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
	$('#policyreset').click(function(){
		$("#customernamemsg").html("");
		$("#policynomsg").html("");
		$("#premiummsg").html("");
  		$("#issuedatemsg").html("");
  		$("#nextpremiumdatemsg").html("");
  		$("#policytermmsg").html("");

	});
});
