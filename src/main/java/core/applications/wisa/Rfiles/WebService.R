.libPaths("/home/raphael/R/x86_64-pc-linux-gnu-library/3.2")
rm(list=ls())
library(Rook)

myPort <- 8081
myInterface <- "0.0.0.0"
status <- -1

#This web service demands that you execute the WisaDST Aplication that return a global JSON Array

#Service for Today Wisa
wisaTodayHTML <- function(request,response, iter) {
   
  #CORS
  response$header("Access-Control-Allow-Origin", "*")
  response$header("Access-Control-Allow-Credentials", "true");
  response$header("Access-Control-Allow-Headers", request$head());
  
  response$write(daily_data)
}

#Service for interval selection Wisa
wisaIntervalHTML <- function(request,response, iter) {
  
  #CORS
  response$header("Access-Control-Allow-Origin", "*")
  response$header("Access-Control-Allow-Credentials", "true");
  response$header("Access-Control-Allow-Headers", request$head());
  Sys.setenv(name=.GlobalEnv)
  response$write(interval_data)
}




#APP WISA TODAY
WisaToday.app <- function(env) {
  request <- Request$new(env);
  response <- Response$new();
  wisaTodayHTML(request,response);
  response$finish();
}

#APP WISA TODAY
WisaInterval.app <- function(env) {
  request <- Request$new(env);
  response <- Response$new();
  wisaIntervalHTML(request,response);
  response$finish();
}


#Start
if (as.integer(R.version[["svn rev"]]) > 59600) {
  status <- .Call(tools:::startHTTPD, myInterface, myPort)
} else {
  status <- .Internal(startHTTPD(myInterface, myPort))
}

.GlobalEnv
status=0
if (status == 0) {
  getSettable <- function(default){
    function(obj = NA){if(!is.na(obj)){default <<- obj};
      default}
  }
  myHttpdPort <- getSettable(myPort)
  unlockBinding("httpdPort", environment(tools:::startDynamicHelp))
  assign("httpdPort", myHttpdPort, environment(tools:::startDynamicHelp))
  
   #unlockBinding("httpdPort", environment(tools:::startDynamicHelp))
  #assign("httpdPort", myPort, environment(tools:::startDynamicHelp))
  s <- Rhttpd$new()
  s$listenAddr <- myInterface
  s$listenPort <- myPort
  #REST ROUTES
  s$add(name = "wisatoday", app = WisaToday.app)
  s$add(name = "wisainterval", app = WisaInterval.app)
  
 # s$start()
}


