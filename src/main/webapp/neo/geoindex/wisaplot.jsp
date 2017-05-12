<html>	
	<body>
		<div>
			<%@ include file="wisa.jsp" %>
		</div>
		
    <div class="container-fluid">
      <div class="tab-content">
        <div id="wisa-dst" class="tab-pane fade in active">
            <div class="panel-group infos" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" href="#wisa">Wisa - DST</a>
                  </h4>
                </div>
                <div id="hdz" class="panel-collapse collapse in">
                  <div class="panel-body">
                  	<iframe src="../../../geoanalysis/geoindex/wisaplotchart.html" width="100%" height="330" scrolling="no" frameborder="0" align="center"></iframe>
				  </div>
                </div>
              </div>
            </div> 
        </div>
      </div>
    </div>
	</body>
</html>