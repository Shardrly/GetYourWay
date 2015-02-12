<jsp:useBean id="airportsearch" class="com.qa.flightsearch.AirportSearch" scope="session"/>
<jsp:useBean id="flightssearch" class="com.qa.flightsearch.FlightsSearch" scope="session"/>

<jsp:setProperty name="airportsearch" property="*"/> 
<jsp:setProperty name="flightssearch" property="*"/> 
<html>
<head>

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
