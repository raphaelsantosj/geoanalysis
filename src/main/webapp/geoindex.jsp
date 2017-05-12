<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/geoindex/geostyle.css">
<link rel="stylesheet" href="css/geoindex/indexstyle.css">  		
<html>
	<head>
		<meta charset="ISO-8859-8">
		
		<%@ include file="header.html" %>
		
	</head>
	
	<body>

<div id="panels" style="display:table;">
	<div class="panel panel-default"  id="geopanel">
	  <div class="panel-heading" id="geopanelheader">
	  	<b>What is Geomagnetic Index?</b>
	  </div>
	  <div class="panel-body">
	Geomagnetic field has been observed routinely at geomagnetic observatories and recorded as "geomagnetic field data".
	This kind of data is essential for research in geomagnetism, for instance, they are indispensable to derivation of geomagnetic indices and geomagnetic field models. 
	Geomagnetic field is a vector and has three components like north-south, east-west, and up-down elements. 
	Geomagnetic indices describe how the geomagnetic field is disturbed.
	<br>
	<br>
	O campo geomagnיtico י observado rotineramente em observatףrios geomagnיticos e sדo gravados como "dados do campo geomagnיtico".
	Esse tipo de dado י essencial para pesquisas em geomagnetismo, sדo indispensבveis para a derivaחדo de indices geomagnיticos e modelos do campo geomagnיtico.
	O campo geomagnיtico י um vetor e possui tres componentes, norte-sul, leste-oeste e uma componente para mediחדo de altura.
	Índices geomagnיticos descrevem a perturbaחדo do campo geomagnיtico.
	<br>

	<br>
	 <a href="http://wdc.kugi.kyoto-u.ac.jp/index.html">Source: World Data Center for Geomagnetism, Kyoto</a>
	  </div>
	</div>
	
	
	<div class="panel panel-default"  id="indexpanel">
	  <div class="panel-heading" id="indexpanelheader">
	  		<div class="btn-group" id="indexbtngroup" role="group" style="margin-left: 42px" >
  				<button type="button" class="btn btn-default" id="bwisa">Wisa</button>
  				<button type="button" class="btn btn-default" id="bmeyer">Meyer</button>
  				<button type="button" class="btn btn-default" id="bwci">WCI</button>
  				<button type="button" class="btn btn-default" id="bwsf">WSF</button>
  				<button type="button" class="btn btn-default" id="bpc">PC</button>
			</div>
	  </div>
	  <div class="panel-body" id="wisapanel" style="display:block"> 
		<div id="textwisa">
			<b>The Wisa-dst index is used to identify geomagnetic storms. The storms can be defined as:</b>
			<br> weak (-50 nT up to -30 nT),
			<br> moderated(-100 nT up to -50 nT), 
			<br> intense (-250 nT up to -100 nT) and
			<br> very intense (less than -250 nT).
			<br><br>
			<b>O םndice Wisa-dst י usado para identificar tempestades geomagnיticas. Essas tempestades podem ser definidas como:</b>
			<br> fracas (-50 nT atי -30 nT),
			<br> moderadas(-100 nT atי -50 nT), 
			<br> intensas (-250 nT atי -100 nT) and
			<br> muito intensas (menos de -250 nT).
			
			<div align="center">
				<img src="geoindex/moderated.png">
				<b>Moderated Geomagnיtic Storm on Sep/12</b>
				<b>Tempestade Geomagnיtica Moderada em 12 de Set</b>
			</div>
			<br>*nT = nanoTeslas 
		</div>
		
	  </div>
	  <div class="panel-body" id="meyerpanel" style="display:none"> Hello meyer </div>
	  <div class="panel-body" id="wcipanel" style="display:none">  Hello wci </div>
	  <div class="panel-body" id="wsfpanel" style="display:none">  Hello wsf </div>
	  <div class="panel-body" id="pcpanel" style="display:none">  Hello PCx </div>
	  
	  
	  	  <script type="text/javascript">
			$(document).ready(function() {
				$("#bwisa").click( function() {
		    		$('#wisapanel').fadeIn("slow"); 
		    		$('#meyerpanel').hide();
		    		$('#wcipanel').hide();
		    		$('#wsfpanel').hide();
		    		$('#pcpanel').hide();
				});
			});
	 	  </script>
	  	  <script type="text/javascript">
			$(document).ready(function() {
				$("#bmeyer").click( function() {
					$('#wisapanel').hide();
		    		$('#meyerpanel').fadeIn("slow"); 
		    		$('#wcipanel').hide();
		    		$('#wsfpanel').hide();
		    		$('#pcpanel').hide();
				});
			});
		  </script>
	 	  <script type="text/javascript">
			$(document).ready(function() {
				$("#bwci").click( function() {
		    		$('#wisapanel').hide(); 
		    		$('#meyerpanel').hide();
		    		$('#wcipanel').fadeIn("slow");
		    		$('#wsfpanel').hide();
		    		$('#pcpanel').hide();
				});
			});
	 </script>
	 	  <script type="text/javascript">
			$(document).ready(function() {
				$("#bwsf").click( function() {
		    		$('#wisapanel').hide(); 
		    		$('#meyerpanel').hide();
		    		$('#wcipanel').hide();
		    		$('#wsfpanel').fadeIn("slow");
		    		$('#pcpanel').hide();
				});
			});
	 </script>
	 	  <script type="text/javascript">
			$(document).ready(function() {
				$("#bpc").click( function() {
		    		$('#wisapanel').hide(); 
		    		$('#meyerpanel').hide();
		    		$('#wcipanel').hide();
		    		$('#wsfpanel').hide();
		    		$('#pcpanel').fadeIn("slow");
				});
			});
	 </script>
	 
	</div>	
</div>

<div class="dropdown" id="indexdropdown" >
   	 	<button class="btn btn-primary dropdown-toggle" id="dropdown" type="button" data-toggle="dropdown">Plot Geomagnetic Index<span class="caret"></span></button>
  	 	<ul class="dropdown-menu" >
    	 	<li><a href="/geoanalysis/geoindex/wisa.jsp">WISA-DST</a></li>
    	 	<li><a href="#">Meyer</a></li>
     	 	<li><a href="#">WCI</a></li>
     	 	<li><a href="#">WSF</a></li>
     	 	<li><a href="#">PC1 to PC6</a></li>
    	</ul>
  	</div>
	</body>
	

</html>