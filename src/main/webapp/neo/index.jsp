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
<link href="assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="assets/css/main.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/animate-custom.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="assets/img/fav.ico" />
<script src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/modernizr.custom.js"></script>
<script type="text/javascript">
  //Funçao subir pagina ao topo
  $(document).ready(function(){
    $('#scrollToTop').click(function(){
      $('html, body').animate({scrollTop : 0},800);
      return false;
    }); 
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
          <li><a href="#home" id="scrollToTop">Home</a></li>
          <li> <a href="#geo-index" class="smoothScroll">Geomagnetic Index</a></li>
          <li> <a href="#observatories" class="smoothScroll">Observatories</a></li>
          <li><a href="pt-br/index.jsp"><img src="assets/img/br.png" width="20"></a></li>
          <li style="margin-left:-20px;"><a href="#eng-us"><img src="assets/img/us.png" width="20"></a></li>
        </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
  </div>
</div>

<!-- ==== Home ==== -->
<div id="home" name="home">
  <header class="clearfix">
    <nav class="navbar navbar-custom submenu">
      <div class="container">
        <ul class="nav nav-pills">
          <li class="active"><a data-toggle="pill" href="#kakioka">Kakioka</a></li>
          <li><a data-toggle="pill" href="#vassouras">Vassouras</a></li>
        </ul>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="tab-content">
        <div id="kakioka" class="tab-pane fade in active">
          <h3>KAKIOKA</h3>
            <div class="panel-group infos" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#hdz">HDZ</a>
                  </h4>
                </div>
                <div id="hdz" class="panel-collapse collapse in">
                  <div class="panel-body">
                  	<iframe src="../../geoanalysis/today/hdztoday.html" width="100%" height="330" scrolling="no" frameborder="0" align="center"></iframe>
				  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#wisa-dst-meyer">WISA-DST and Meyer</a>
                  </h4>
                </div>
                <div id="wisa-dst-meyer" class="panel-collapse collapse in">
                  <div class="panel-body">
                  	<iframe src="../../geoanalysis/today/wisatoday.html" width="100%" height="330" scrolling="no" frameborder="0" align="center"></iframe>
				  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#pc">PC1...PCx</a>
                  </h4>
                </div>
                <div id="pc" class="panel-collapse collapse in">
                  <div class="panel-body">
					<img src="../wisaPlots/wisadst.png" alt=""> 
					<img src="../wisaPlots/wisadst.png" alt=""> 
				  </div>
                </div>
              </div>
            </div> 
        </div>
        <div id="vassouras" class="tab-pane fade">
          <h3>VASSOURAS</h3>
            <div class="panel-group infos" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#hdz">HDZ</a>
                  </h4>
                </div>
                <div id="hdz" class="panel-collapse collapse in">
                  <div class="panel-body">
                  	<iframe src="../../geoanalysis/today/hdztoday.html" width="100%" height="330" scrolling="no" frameborder="0" align="center"></iframe>
				  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#wisa-dst-meyer">WISA-DST and Meyer</a>
                  </h4>
                </div>
                <div id="wisa-dst-meyer" class="panel-collapse collapse in">
                  <div class="panel-body">
                  	<iframe src="../../geoanalysis/today/wisatoday.html" width="100%" height="330" scrolling="no" frameborder="0" align="center"></iframe>
				  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#pc">PC1...PCx</a>
                  </h4>
                </div>
                <div id="pc" class="panel-collapse collapse in">
                  <div class="panel-body">
					<img src="../wisaPlots/wisadst.png" alt=""> 
					<img src="../wisaPlots/wisadst.png" alt=""> 
				  </div>
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>
</div>
<!-- /home --> 

<div class="container-fluid"><span class="top-line"></span></div>

<!-- ==== Geomagnetic Index ==== -->
<div id="geo-index" name="geo-index">
  <div class="container">
    <div class="row white">
      <div class="col-md-6">
        <h3 class="title-geo">What is Geomagnetic Index?</h3>
        <p>Geomagnetic field has been observed routinely at geomagnetic observatories and recorded as "geomagnetic field data". This kind of data is essential for research in geomagnetism, for instance, they are indispensable to derivation of geomagnetic indices and geomagnetic field models. Geomagnetic field is a vector and has three components like north-south, east-west, and up-down elements. Geomagnetic indices describe how the geomagnetic field is disturbed.</p>

        <a href="http://wdc.kugi.kyoto-u.ac.jp/index.html" target="_blank">Source: World Data Center for Geomagnetism, Kyoto</a>

        <div class="dropdown" style="margin-top: 100px;">
          <button class="btn btn-options dropdown-toggle" type="button" data-toggle="dropdown">Plot Geomagnetic Index
          <span class="caret"></span></button>
          <ul class="dropdown-menu">
            <li><a href="geoindex/wisa.jsp">WISA-DST</a></li>
            <li><a href="#">Meyer</a></li>
            <li><a href="#">WCI</a></li>
            <li><a href="#">WSF</a></li>
            <li><a href="#">PC1 to PC6</a></li>
          </ul>
        </div>
      </div>

      <div class="col-md-6">
        <ul class="nav nav-tabs ">
          <li class="active"><a data-toggle="tab" href="#wisa">Wisa</a></li>
          <li><a data-toggle="tab" href="#meyer">Meyer</a></li>
          <li><a data-toggle="tab" href="#wci">WCI</a></li>
          <li><a data-toggle="tab" href="#wsf">WSF</a></li>
          <li><a data-toggle="tab" href="#pc">PC</a></li>
        </ul>

        <div class="tab-content">
          <div id="wisa" class="tab-pane fade in active">
            <h3>Wisa</h3>
            <p>The Wisa-dst index is used to identify geomagnetic storms. The storms can be defined as: 
            weak (-50 nT up to -30 nT), 
            moderated(-100 nT up to -50 nT), 
            intense (-250 nT up to -100 nT) and 
            very intense (less than -250 nT). 
            </p>
            <img id="centralizar-img" src="assets/img/moderated.png" class="img-responsive"></img>
            <p>*nT = nanoTeslas</p>
          </div>
          <div id="meyer" class="tab-pane fade">
            <h3>Meyer</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
          </div>
          <div id="wci" class="tab-pane fade">
            <h3>WCI</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
          </div>
          <div id="wsf" class="tab-pane fade">
            <h3>WSF</h3>
            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
          </div>
          <div id="pc" class="tab-pane fade">
            <h3>PC</h3>
            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
          </div>
        </div>
      </div>
    </div>
    <!-- row --> 
  </div>
</div>
<!-- container --> 

<!-- ==== Solar Storm ==== -->
<div id="solarstorm" name="solarstorm"></div>

<!-- ==== Observatories ==== -->
<div id="observatories" name="observatories">
  <div class="container">
    <div class="row">
      <h2 class="centered">Observatories</h2>
      <span class="bot-line"></span>
      <div class="col-md-12 centered observs">
        <div class="col-md-9" style="border-bottom: 2px solid #e2e2e2; margin-top: 5px; padding-bottom: 20px;">
          <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3218.220715765865!2d140.189384!3d36.234132!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x7353fd30f962cc33!2z5Zyw56OB5rCX6Kaz5ris5omA!5e0!3m2!1spt-BR!2spt!4v1486413914959" width='100%' height='100%' frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>

        <div class="col-md-3" style="border-bottom: 2px solid #e2e2e2; margin-top: 5px; padding-bottom: 25px">
          <p class="titulo">Kakioka<p>
          <p>Country: Japan</p>
          <p>East Logitude: 140.18</p>
          <p>Colatitude: 53.77</p>
        </div>

        <div class="col-md-9" style="margin-top: 25px;">
          <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14755.105176080266!2d-43.6536759!3d-22.3997893!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xd4e19090b557ef16!2sObservat%C3%B3rio+Nacional!5e0!3m2!1spt-BR!2sbr!4v1486414154214" width="100%" height="100%" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>

        <div class="col-md-3" style="margin-top: 30px;">
          <p class="titulo">Vassouras<p>
          <p>Country: Brazil</p>
          <p>East Logitude: 316.35</p>
          <p>Colatitude: 112.4</p>
        </div>
      </div>
    </div>
    <!-- /row -->
  </div>
</div>
<!-- /container --> 

<div id="footerwrap">
  <div class="container">
    <div class="row">
      <div class="col-md-12"> <span class="copyright">Copyright &copy; 2017 INPE</span> </div>
    </div>
  </div>
</div>
                                                                                                                                                                                                                                     
<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 

<script type="text/javascript" src="assets/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="assets/js/retina.js"></script> 
<script type="text/javascript" src="assets/js/jquery.easing.1.3.js"></script> 
<script type="text/javascript" src="assets/js/smoothscroll.js"></script> 
<script type="text/javascript" src="assets/js/jquery-func.js"></script>
</body>
</html>