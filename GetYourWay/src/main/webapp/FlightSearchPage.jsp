
<jsp:include page="/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	})
</script>
</head>


<body>

	<script type="text/javascript">
		var customersearchlat = [];
		var customersearchlong = [];
		function myIP() {
			var geocoder = new google.maps.Geocoder();
			geocoder
					.geocode(
							{
								'address' : $('#origin').val()
							},
							function(results, status) {
								if (status == google.maps.GeocoderStatus.OK) {
									customersearchlat[customersearchlat.length] = results[0].geometry.location
											.lat();
									alert(customersearchlat[customersearchlat.length]);
									customersearchlong[customersearchlong.length] = results[0].geometry.location
											.lng();
									alert(customersearchlong[customersearchlong.length]);
								} else {
									$('.push-down').text(
											"Something went wrong " + status);
								}
							});
			geocoder
					.geocode(
							{
								'address' : $('#dest').val()
							},
							function(results, status) {
								if (status == google.maps.GeocoderStatus.OK) {
									customersearchlat[customersearchlat.length] = results[0].geometry.location
											.lat();
									customersearchlong[customersearchlong.length] = results[0].geometry.location
											.lng();
								} else {
									$('.push-down').text(
											"Something went wrong " + status);
								}
							});
		};
	</script>
	<script>
		$(function() {
			$('#originlat').val(customersearchlat[0]);
		});
		$(function() {
			$('#originlong').val(customersearchlong[0]);
		});
		$(function() {
			$('#destlat').val(customersearchlat[1]);
		});
		$(function() {
			$('#destlong').val(customersearchlong[1]);
		});
	</script>


<style>
.push-down {
	margin-top: 25px;
}
</style>
</head>

<body>
<body onload="myIP()">
	<form method="post" action="SearchResults.uspr">
		Origin: <input id="origin" type="TEXT" name="origin" required>
		<br> Destination: <input id="dest" type="TEXT" name="destination"
			required>
		<p>
			Date: <input type="text" id="datepicker" required name="datepicker">
		</p>
		<input type="hidden" id="originlat" name="originlat"/> 
		<input type="hidden" id="originlong" name="originlong"/> 
		<input type="hidden" id="destlat" name="destlat"/>
		<input type="hidden" id="destlong" name="destlong"/> 
		Submit search <input type="submit"value="Submit" />
		<select  name="mode">
		<option value="Flights">Flight</option>
		<option value="DrivingResults">Driving</option>
		</select>
	</form>



</body>

<div id=botDoc>
	<jsp:include page="/footer.jsp" />
</div>
</html>