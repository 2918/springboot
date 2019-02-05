<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Form</title>
		<link type="text/css" href="static/css/bootstrap.min.css" rel="stylesheet"/>
<script  src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="   crossorigin="anonymous"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/policy.js"></script>
		
	</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
  <form class="form-horizontal" action="issuePolicy" method="post" name="policyForm">
    <div class="row">
       <div class="col-sm-8" style="background-color: lavender;">	<h2>Issue Policy Form</h2></div>
   </div>
   <div class="row">
      <div class="col-sm-8" style="background-color: lavender;"><span id="statusMessage"> </span></div>
   </div>
   <div class="row">
     <div class="col-sm-8" style="background-color: lavenderblush;">
     <br/>
     <div class="form-group">
		<label class="control-label col-sm-3" for="customerName">Customer Name</label>
		<div class="col-sm-5">
			<select class="form-control" id="customerName" name="customerName">
			</select>	
				<span id="customernamemsg"></span>
		</div>
      </div>
  
      <div class="form-group">
       	<label class="control-label col-sm-3" for="policyNo">Policy Number</label>
        <div class="col-sm-5">
	        <input type="text" class="form-control" id="policyno" name="policyno"/>
	        <span id="policynomsg"></span>
        </div>
      </div>
  	<div class="form-group">
		<label class="control-label col-sm-3" for="premium">Premium</label>
		<div class="col-sm-5">
			<input type="number" class="form-control" id="premium"	name="premium">
			<span id="premiummsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="issuedate">Issue Date</label>
		<div class="col-sm-5">
			<input type="date" class="form-control" id="issueDate"
				name="issueDate">
				<span id="issuedatemsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="nextpremiumdate">Next Premium Date</label>
		<div class="col-sm-5">
			<input type="date" class="form-control" id="nextPremiumDate"
				name="nextPremiumDate">
				<span id="nextpremiumdatemsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="policyTerm">Policy Term</label>
		<div class="col-sm-5">
			<select class="form-control" id="policyTerm"
				name="policyTerm">
				<option value="H">Half Yearly</option>
				<option value="Y">Yearly</option>
				<option value="Q">Quaterly</option>
				<option value="M">Monthly</option>
			</select>
				<span id="policytermmsg"></span>
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
</form>
</div>

</body>
</html>