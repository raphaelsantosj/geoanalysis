<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Geomagnetic Disturbance Analysis</title>

<!-- Bootstrap core CSS -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../assets/css/main.css" rel="stylesheet">
<link href="../assets/css/font-awesome.min.css" rel="stylesheet">
<link href="../assets/css/animate-custom.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="../assets/js/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript" src="../assets/js/modernizr.custom.js"></script>
<script type="text/javascript" src="../assets/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
  //Mascara data
  jQuery(function($){
    $("#datai").mask("99/99/9999");
    $("#dataf").mask("99/99/9999");
  });
</script>

</head>
<body data-spy="scroll" data-offset="0" data-target="#navbar-main">
<div id="navbar-main"> 
  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="#home"><i class="fa fa-bar-chart"></i>&nbsp;Geomagnetic Disturbance Analysis</a>
      </div>

      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="../index.jsp">Home</a></li>
          <li> <a href="../index.jsp#geo-index" class="smoothScroll">Geomagnetic Index</a></li>
          <li> <a href="../index.jsp#observatories" class="smoothScroll">Observatories</a></li>
          <li> <a href="../index.jsp#feedback" class="smoothScroll">Feedback</a></li>
        </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
  </div>
</div>

<!-- ==== Home ==== -->
<div id="home" name="home">
  <div id="form-data" class="container">
    <form class="col-md-12" action="wisaplot" method="get">
      <div class="form-group col-md-4">
        <label>Data inicial: </label>    
        <input id="datai" name="datai" type="text" class="form-control" placeholder="dd/mm/aaaa" />
      </div>
      <div class="form-group col-md-4">
        <label>Data final: </label>    
        <input id="dataf" name="dataf" type="text" class="form-control" placeholder="dd/mm/aaaa"/>
      </div>
      <div class="form-group col-md-4">
        <button type="submit" class="btn btn-enviar" onclick="mudarestado()">Enviar</button>
      </div>
      
		<script>
			function mudarestado() {
				document.getElementById("bar1").style.display = 'block';
			}
			
			$(function() {
				$("#datai").datepicker({
			        dateFormat: 'dd/mm/yy',
			        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
			        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
			        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
			        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
			    });
			});
			
			$(function() {
				$("#dataf").datepicker({
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
</div>
<!-- /home -->

                                                                                                                                                                                                                                     
<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 

<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="../assets/js/retina.js"></script> 
<script type="text/javascript" src="../assets/js/jquery.easing.1.3.js"></script> 
<script type="text/javascript" src="../assets/js/smoothscroll.js"></script> 
<script type="text/javascript" src="../assets/js/jquery-func.js"></script>
</body>
</html>