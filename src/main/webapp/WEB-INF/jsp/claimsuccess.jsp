
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="static/css/bootstrap.min.css" rel="stylesheet"/>
<script  src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="   crossorigin="anonymous"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
	<h2> Claim Success Page</h2>
	
	<h2> 
		Hello ${claim.customerName },
		Your claim request is submitted successfully.
		
		${sessionScope.claim.customerName }	
	</h2>
</body>
</html>