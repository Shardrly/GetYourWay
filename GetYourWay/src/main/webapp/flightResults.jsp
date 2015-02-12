<%@page import="java.util.ArrayList"%>
<html>
<head>

</head>
<body>
<jsp:include page="/header.jsp"/>    
  
 <h2><%=((ArrayList)request.getAttribute("Schedule")).get(0) %></h2>


<iframe src="weather.html" height="500px" width="700px" scrolling="no" style="overflow: hidden">
</iframe>
	



</body>
<div id= botDoc>
<jsp:include page="/footer.jsp"/>
</div>
</html>
