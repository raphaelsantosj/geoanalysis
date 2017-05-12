

<html>

	<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
  	<%@ include file="header.html" %>
	</head>
	<body>


<br>
<div class="btn-group" role="group" aria-label="">
  <button type="button" class="btn btn-default" id="kakbtn">Kakioka</button>
  <button type="button" class="btn btn-default" id="vssbtn">Vassouras</button>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("#vssbtn").click( function() {
    		$('#kak').hide(); 
    		$('#vss').fadeIn("slow");
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#kakbtn").click( function() {
	    	$('#kak').fadeIn("slow");
	    	$('#vss').hide(); 
		});
	});
</script>

<div id="kak" style="display: block;">
	<div id="allImageskak" align="center">
		<div class="mostrarkak" align="center" style="display: block;">
			<h6>HDZ</h6> <br>
			<iframe src="/geoanalysis/today/hdztoday.html" width="800" height="330" scrolling="no" frameborder="0" align="center"></iframe>
		</div>
		<div class="mostrarkak" style="display: none;"> 
			<h6>WISA-DST</h6> <br>
			<iframe src="/geoanalysis/today/wisatoday.html" width="800" height="330" scrolling="no" frameborder="0" align="center"></iframe>
		</div>
	
		<div class="mostrarkak" style="display: none;">
			<h6>WCI and WSF</h6> <br>
			<img src="wisaPlots/wisadst.png" alt=""> 
			<img src="wisaPlots/wisadst.png" alt=""> 
		</div>
		
		<div class="mostrarkak" style="display: none;"> 
			<h6>PC1...PCx (?)</h6> <br>
			<img src="wisaPlots/wisadst.png" alt="">
			<img src="wisaPlots/wisadst.png" alt="">
			<img src="wisaPlots/wisadst.png" alt="">
			
			
		</div>
	</div>
	<br />
	<div align="center">
	<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" id="botaokak">
	  <i class="material-icons">add</i>
	</button>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#botaokak").click( function() {
				$('.mostrarkak[style="display: none;"]:first').fadeIn("slow");
				if ($('.mostrarkak[style="display: none;"]').length == 0) {
		        	$(this).fadeOut('slow');
				}
			} );
		});
	</script>
</div>  
      
<div id="vss" style="display: none;">
	<div id="allImagesvss" align="center">
		<div class="mostrarvss" style="display: block;">
			<h6>HDZ (?)</h6> <br>
			<img src="wisaPlots/vss.jpg" alt=""> 
		</div>
		<div class="mostrarvss" style="display: none;"> 
			<h6>WISA-DST and Meyer</h6> <br>
			<img src="wisaPlots/vss.jpg" alt="">
			<img src="wisaPlots/vss.jpg" alt="">
		</div>
	
		<div class="mostrarvss" style="display: none;">
			<h6>WCI and WSF</h6> <br>
			<img src="wisaPlots/vss.jpg" alt=""> 
			<img src="wisaPlots/vss.jpg" alt=""> 
		</div>
		
		<div class="mostrarvss" style="display: none;"> 
			<h6>PC1...PCx (?)</h6> <br>
			<img src="wisaPlots/vss.jpg" alt="">
			<img src="wisaPlots/vss.jpg" alt="">
			<img src="wisaPlots/vss.jpg" alt="">
			
			
		</div>
	</div>
	<br />
	<div align="center">
	<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" id="botaovss">
	  <i class="material-icons">add</i>
	</button>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#botaovss").click( function() {
				$('.mostrarvss[style="display: none;"]:first').fadeIn("slow");
				if ($('.mostrarvss[style="display: none;"]').length == 0) {
		        	$(this).fadeOut('slow');
				}
			} );
		});
	</script>
</div>        


  </body>
</html>
