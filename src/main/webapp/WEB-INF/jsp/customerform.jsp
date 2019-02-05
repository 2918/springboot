<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Form</title>
		<link type="text/css" href="static/css/bootstrap.min.css" rel="stylesheet"/>
<script  src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="   crossorigin="anonymous"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/customer.js"></script>
		
	</head>
<body>

<%@include file="header.jsp"%>


<div class="container">
  <form class="form-horizontal" action="/saveCustomer" method="post" name="customerForm">
    <div class="row">
       <div class="col-sm-12" style="background-color: lavender;">	<h2>New Customer Entry Form</h2></div>
   </div>
   <div class="row">
      <div class="col-sm-12" style="background-color: lavender;"><span id="statusMessage"> </span></div>
   </div>
   <div class="row">
     <div class="col-sm-6" style="background-color: lavenderblush;">
     <p>Customer Details</p>
      <div class="form-group">
       	<label class="control-label col-sm-3" for="customerId">CustomerId</label>
        <div class="col-sm-5">
	        <input type="text" class="form-control" id="customerId" name="customerId">
	        <span id="customeridmsg"></span>
        </div>
      </div>
     <div class="form-group">
		<label class="control-label col-sm-3" for="customerName">Name</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="customerName"
				name="customerName">
				<span id="customernamemsg"></span>
		</div>
      </div>

     <div class="form-group">
		<label class="control-label col-sm-3" for="occupation">Occupation</label>
     <div class="col-sm-5">
	  <select id="occupation" name="occupation" class="form-control">
	  <option value=""></option>
		<option value="Doctor">Doctor</option>
		<option value="Engineer">Engineer</option>
		<option value="Govt Employee">Govt Employee</option>
		<option value="Private Employee">Private Employee</option>
		<option value="Business">Business</option>
		<option value="Teacher">Teacher</option>
	</select>
	<span id="occupationmsg"></span>
</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="">Qualification</label>
	<div class="col-sm-5">
		<select id="qualification" name="qualification" class="form-control">
		<option value=""></option>
			<option value="BE">Bachelor Engineering</option>
			<option value="MCA">Master Computer Applications</option>
			<option value="Phd">PH.D</option>
			<option value="MA">Master of Arts</option>
			<option value="MBBS">MBBS</option>
			<option value="Graduate">Greduate</option>
			</select>
			<span id="qualificationmsg"></span>
	</div>
</div>
</div>

<div class="col-sm-6" style="background-color: lavenderblush;">
	<p>Customer Address</p>
	<div class="form-group">
		<label class="control-label col-sm-3" for="doorno">Doorno</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="doorno"	name="doorno">
			<span id="doornomsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="street">Street</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="street"
				name="street">
				<span id="streetmsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="city">City</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="city"
				name="city">
				<span id="citymsg"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-3" for="pincode">Pincode</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="pincode"
				name="pincode">
				<span id="pincodemsg"></span>
		</div>
	</div>
</div>
</div>

<div class="row">
<div class="col-sm-12" style="background-color: lavender;">
<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10" style="align:center">
      <button type="submit" id="customersave" class="btn btn-default">Submit</button>
            <button type="reset" id="reset" class="btn btn-default">Clear Form</button>
    </div>
  </div>
</div>
</div>
</form>
</div>

</body>
</html>