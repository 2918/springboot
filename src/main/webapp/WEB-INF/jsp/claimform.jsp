<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Claim Form</title>
		<link type="text/css" href="static/css/bootstrap.min.css" rel="stylesheet"/>
		<script  src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="   crossorigin="anonymous"></script>
		<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="static/js/claim.js"></script>
		
	</head>
<body>

<%@include file="header.jsp"%>

<div class="container">
  <form:form class="form-horizontal" action="newClaim" method="post" name="claimForm" modelAttribute="claim">
    <div class="row">
       <div class="col-sm-8" style="background-color: lavender;"><h2>New Claim Form</h2></div>
   </div>
   <div class="row">
      <div class="col-sm-8" style="background-color: lavender;"><span id="statusMessage">${claimMessage} </span></div>
   </div>
   <div class="row">
     <div class="col-sm-8" style="background-color: lavenderblush;">
     <br/>  
      <div class="form-group">
       	<label class="control-label col-sm-3" for="policyNo">Policy Number</label>
        <div class="col-sm-5">
	        <form:input cssClass="form-control" id="policyNo" path="policyNo"/>
	        <form:errors path="policyNo"></form:errors>
	        
        </div>
      </div>
      <div class="form-group">
		<label class="control-label col-sm-3" for="customerName">Customer Name</label>
		<div class="col-sm-5">
			<form:input cssClass="form-control" readonly="true" id="customerName" path="customerName"/>
	        <form:errors path="customerName"></form:errors>
		</div>
      </div>
      
  	<div class="form-group">
		<label class="control-label col-sm-3" for="claimAmount">Claim Amount</label>
		<div class="col-sm-5">
			<form:input cssClass="form-control" id="claimAmount"	path="claimAmount"/>
	        <form:errors path="claimAmount"></form:errors>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="claimDate">Claim Date</label>
		<div class="col-sm-5">
			<form:input   cssClass="form-control" id="claimDate" path="claimDate"/>
	        <form:errors path="claimDate"></form:errors>
		</div>
	</div>
</div>
</div>
<div class="row">
<div class="col-sm-8" style="background-color: lavender;">
<div class="form-group"> 
    <div class="col-sm-offset-3 col-sm-5" style="align:center">
      <button type="submit" id="issuePolicy" class="btn btn-default">Submit</button>
            <button type="reset" id="policyreset" class="btn btn-default">Clear Form</button>
    </div>
  </div>
</div>
</div>
</form:form>
</div>
</body>
</html>
