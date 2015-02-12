<!DOCTYPE html>
<jsp:useBean id="com.qa.flightsearch" class="com.qa.flightsearch.AirportSearch" scope="session"/>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="NewFile.css" rel="stylesheet" type="text/css">
<title>Search</title>
</head>
<body>
<jsp:include page="/header.jsp"/>    
  

<iframe src="weather.html" height="500px" width="700px" scrolling="no" style="overflow: hidden">
</iframe>



</body>
<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>
</html>
