<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<div id="header"></div>

	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>HelloWorld example</h2>
			<p>This example is a quick exercise to illustrate spring MVC.</p>
			<p>
				<a class="btn btn-lg btn-primary"
					href="hello?name=the Spring Learning Team!" role="button">View
					Spring HelloWorld &raquo;</a>
			</p>
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
</body>
</html>
