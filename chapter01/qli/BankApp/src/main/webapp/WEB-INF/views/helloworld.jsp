<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <div id="header"></div>
    
    	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>HelloWorld example</h2>
			<p class="alert alert-success"> <strong>${message}</strong> ${name}</p>
			<p><a class="btn btn-lg btn-primary"
					href="/HelloWorld/" role="button">&laquo; Click here to Go Back! </a></p>
		</div>
	</div>
	<!-- /container -->
	
		<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script> 
	$(function(){
	  $("#header").load("views/header.html"); 
	});
	</script>
	
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <title>Spring learning HelloWorld</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<center> -->
<!-- 		<h2>Spring Hello World BankApp</h2> -->
<!-- 		<h2> -->
<%-- 			${message} ${name} --%>
<!-- 		</h2> -->
<!-- 	</center> -->
</body>
</html>