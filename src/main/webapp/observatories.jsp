<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
<link rel="stylesheet" href="css/observatories.css">


<html>
<title>Observatories</title>
	
	<body>
		<div>
			<%@ include file="header.html" %>
		</div>
		
		<div align="center">
		<br>
		<br>
		<br>
			<div id="panels" class="row" align="center" style="display:table;">
				<div id="p1" align="left"> 
					<table class="table">
						<caption><b>Kakioka</b></caption>
						<tr>
					    	<th>Country:</th>
    						<td>Japan</td>
    					</tr>
    					<tr>
    						<th>East Longitude:</th>
    						<td>140.18</td>
    					</tr>
    					<tr>
    						<th>Colatitude:</th>
    						<td>53.77</td>
					  	</tr>
					</table>
				</div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div id="p2" align="right">
					<table class="table">
					<caption><b>Vassouras</b></caption>
 						<tr>
					    	<th>Country:</th>
    						<td>Brazil</td>
    					</tr>
    					<tr>
    						<th>East Longitude:</th>
    						<td>316.35</td>
    					</tr>
    					<tr>
    						<th>Colatitude:</th>
    						<td>112.4</td>
					  	</tr>
					</table>
				</div>
			</div>
			
			<div id="map">
				<iframe src="https://www.google.com/maps/d/embed?mid=1yCiW_8J9t8gfN2n7kjfPzunE0PI" width="640" height="480"></iframe>
			</div>
		</div>
	</body>
	

</html>