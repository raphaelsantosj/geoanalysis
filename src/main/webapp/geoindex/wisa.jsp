<link rel="stylesheet" href="css/plot.css">

<html>

	<head>
		
  		<%@ include file="header.html" %>
	</head>
	
	<body>
		<div id="formwisa">      
	      <form class="form col-md-12 center-block espaco" action="wisaplot" method="get">
	      
	      		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
	   				 <label class="mdl-textfield__label" for="dIni">Data Inicial</label>
	   				 <input class="mdl-textfield__input" type="text" id="dini" name="dini" placeholder=" " onkeyup="datebar(this);">
	    		 </div>
					
				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<label class="mdl-textfield__label" for="sample3">Data Final</label>
	    			<input class="mdl-textfield__input" type="text" id="dfinal" name="dfinal" placeholder=" " onkeyup="datebar(this);">
	    		</div>
	        	            
	            <div class="form-group">
	              <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="enviar" onclick="mudarestado()">Enviar</button>
	              
	                  	
	            </div>
				<script>
					function datebar(c){
					  if(c.value.length ==2 || c.value.length == 5){
						c.value += '/';
					  }
					}
				</script>
	            <script>
	            	function mudarestado() {
	 
	                    	document.getElementById("bar1").style.display = 'block';
	            	}
	            
					$(function() {
						$("#dini").datepicker({
					        dateFormat: 'dd/mm/yy',
					        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
					        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
					        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
					        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
					        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
					    });
					});
			  </script>
			  <script>
					$(function() {
						$("#dfinal").datepicker({
					        dateFormat: 'dd/mm/yy',
					        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
					        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
					        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
					        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
					        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
					    });
					});
			  </script>
	
	      </form>
	 </div>     
  </body>
</html>
