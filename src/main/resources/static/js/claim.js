$(document).ready(function(){
	alert("calling");
	//Load Customer name.	
	$('#policyNo').blur(function(){

		$.ajax({
			type : "GET",
			url : "/findCustomer",
			data : "policyNo=" + $('#policyNo').val(),
			contentType : "application/json",
			success : function(customerResponse) {
				console.log(customerResponse);
				if(customerResponse.validated) {
					$('#statusMessage').html("");
					$('#customerName').val(customerResponse.customerTO.customerName);
				}
				else{
					$('#statusMessage').html("Policyno doesn't exist");
				}
			},
			error : function(xhr, error){
				console.log(error);
				$('#statusMessage').html("Error while retrieving customer record.");
			}
		});
	})
});
