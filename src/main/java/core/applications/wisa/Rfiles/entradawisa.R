.libPaths("/home/raphael/R/x86_64-pc-linux-gnu-library/3.2/")
# entradawisa.R 
#
#O programa carrega as entradas dos dados e executa as funções 
# para o cálculo do índice wisa utilisando o pacote iWISA.
#
# José P. Marchezi 18/03/2015 **
############################################################

n.levels<-11
J0<-7
J1<-10

toGlobal <- function(var, data, env=globalenv()){
  assign(var, data, envir=globalenv())

  
}

start <- function(dIni, dFinal, isDaily){
  
  year <<- as.numeric(substr(dIni, 1, 4))
  

  library(MASS)
  library('jsonlite')
  
  setwd('/home/raphael/workspace/geoanalysis/src/main/java/core/applications/wisa/Rfiles/')
  coord <- read.table('coord.txt')

  if(isDaily==1){
    data <- fromJSON('http://localhost:9090/geoanalysis/rest/wisadata/wisatodaydata')
  }
  else{
    data <- fromJSON(paste('http://localhost:9090/geoanalysis/rest/wisadata/wisainterval?dates=', dIni, '-', dFinal, sep = ""))
  }
  
  
  dados = matrix (c(data$hHer, data$hHon, data$hKak, data$hSjg), nrow = length(data$hKak), ncol = 4)
  len = length(dados[,1])
  N <- len
  Dim<-dim(dados)
  nD<-Dim[2]
  

  source("index.R")
  wisa<-SAIndex(dados,coord,wf="la8")
  Wisa<-matrix(wisa,N,1)
  
  
  #dIni <- as.numeric(as.POSIXct(as.Date(dIni)+0.125, format="%y/%m/%d"))*1000
  #dFinal <- as.numeric(as.POSIXct(as.Date(dFinal)+0.125, format="%y/%m/%d"))*1000
  #t <- seq(dIni, dFinal, len=len)
  source("dataVariation.R")
  t <- dateVariation(dIni, dFinal)

  ultima <- toJSON(matrix(c(t, wisa), nrow=length(wisa), ncol = 2))
  
  
  return(ultima)

}  


