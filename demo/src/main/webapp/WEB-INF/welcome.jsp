<!DOCTYPE html>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->

</head>
<body>

Choose file to upload<br>
<form action="http://localhost:9000/demo/rest/upload" method="post" enctype="multipart/form-data">
	<input name="file" id="filename" type="file" /><br><br>
	<button name="submit" type="submit">Upload</button>
</form>

	
	<div>
		<ul>
			
		</ul>
	</div>
	
</body>

</html>