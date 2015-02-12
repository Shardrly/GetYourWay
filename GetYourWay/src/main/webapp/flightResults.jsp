<%@page import="com.qa.web.ScheduledFlights"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

</head>
<body>
<jsp:include page="/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
 <h2>Flight Results</h2>


<iframe src="weather.html" height="500px" width="700px" scrolling="no" style="overflow: hidden">
</iframe>
	
	
<table border="1" width="100px">
<c:forEach var="af" items="${requestScope.Schedule}">
	<tr>
		<td>
			<c:out value="${af.scheduledFlights[0].arrivalAirport.name}"></c:out>
		</td>
		<c:forEach var="f" items="${af.scheduledFlights}">
			<td>
				<c:out value="${f.flightNumber}"></c:out>
			<td>
		</c:forEach>
	</tr>
</c:forEach>
</table>


</body>
<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>
</html>
