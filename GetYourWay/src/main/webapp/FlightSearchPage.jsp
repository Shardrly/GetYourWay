
<jsp:include page="/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>
</head>


<body>


<script type="text/javascript">
	function myIP() {
		$("#btn").click(
				function() {

					var geocoder = new google.maps.Geocoder();
					geocoder.geocode({
						'address' : $('#city').val()
					}, function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {
							$('.push-down').text(
									"location : "
											+ results[0].geometry.location
													.lat()
											+ " "
											+ results[0].geometry.location
													.lng());
						} else {
							$('.push-down').text(
									"Something went wrong " + status);
						}
					});
				});
	}
</script>
<style>
.push-down {
	margin-top: 25px;
}
</style>

</head>

<body>

	<body onload="myIP()">
	<input type="text" id="city">
			<input id="btn" type="button" value="get Lat&Long" />
			<div class="push-down"></div>

	<form method="post" action="flightResults.jsp">
		Origin: <input type="TEXT" size="10" name="origin"> <br>

		Destination: <input id="city" type="TEXT">
		<input id="btn" type="button" value="Destination" />
		
		<p>Date: <input type="text" id="datepicker"></p>
		
		Date you would like to travel on: <input type="submit" value="Submit" />
	</form>

</body>

<div id=botDoc>
	<jsp:include page="/footer.jsp" />
</div>
</html>