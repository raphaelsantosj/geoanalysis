#############################################
############## REPLACE MISSING VALUES #######
#############################################
#
# José P. Marchezi 18/03/2015 **
#
# optional
missing.linear<-function(data,num){
N<-length(data)
ind<-1:N
miss.ind<-NULL
miss.sum<-0
misslog<-data==num
if(length(data[misslog])>0 & length(data[misslog])<(N-1))
{
data[misslog]<-approx(x=ind[!misslog],y=data[!misslog],xout=ind
[misslog],method="linear",n=length(ind[misslog]),
rule=2)$y
miss.sum<-sum((rep(1,N))[misslog])
miss.ind<-ind[misslog]
}
list(data=data,miss.sum=miss.sum,miss.ind=miss.ind)
}

##################################################################
# Level--dependent, quantile--based thresholding
# wc - collection of the wavelet coefficients
# which.levels - which levels are to be deseasonalized
# hard - if TRUE, hard thresholding will be applied
# is FALSE - soft
# quantile - which quantile will be used in shrinkage
# type: help(da.thresh) for similar routines in R package waveslim
##################################################################
quantile.manual.thresh.scalewise<-function(wc, which.levels=which.levels, hard = TRUE,quantile=quantile)
{
wc.shrink <- wc
if (hard) {
for (i in names(wc)[which.levels]) {
wci <- wc[[i]]
unithresh <- quantile(abs(wci),quantile)
wc.shrink[[i]] <- wci * (abs(wci) > unithresh)
}
}
else {
for (i in names(wc)[which.levels]) {
wci <- wc[[i]]
unithresh <- quantile(abs(wci),quantile)
wc.shrink[[i]] <- sign(wci) * (abs(wci) - unithresh) * (abs(wci) > unithresh)
}
}
wc.shrink
}
###########################################################
# MRA based on the coefficients and not the series
# we modified waveslim routine mra so that # MRA can be 
#computed based on coefficients; # Splus has both routines,
#R only data-based
###########################################################
mra.wt<-function(x.wt)
{
wf<-attr(x.wt,"wavelet")
J<-length(x.wt)-1
method<-attr(x.wt,"class")
boundary<-attr(x.wt,"boundary")
if(method=="modwt") n<-length(x.wt[[1]])
else n<-2*length(x.wt[[1]])

x.mra <- vector("list", J + 1)
zero <- vector("list", J + 1)
names(zero) <- c(paste("d", 1:J, sep = ""), paste("s", J,
sep = ""))
class(zero) <- method
attr(zero, "wavelet") <- wf
attr(zero, "boundary") <- boundary
zero[[J + 1]] <- x.wt[[J + 1]]
if (method == "modwt") {
for (k in 1:J) zero[[k]] <- numeric(n)
x.mra[[J + 1]] <- imodwt(zero)
}
else {
for (k in 1:J) zero[[k]] <- numeric(n/2^k)
x.mra[[J + 1]] <- idwt(zero)
}
for (j in J:1) {
zero <- vector("list", j + 1)
names(zero) <- c(paste("d", 1:j, sep = ""), paste("s",
j, sep = ""))
class(zero) <- method
attr(zero, "wavelet") <- wf
attr(zero, "boundary") <- boundary
zero[[j]] <- x.wt[[j]]
if (method == "modwt") {
if (j != 1) {
for (k in c(j + 1, (j - 1):1)) zero[[k]] <- numeric(n)
}
else {
zero[[j + 1]] <- numeric(n)
}
x.mra[[j]] <- imodwt(zero)
}
else {
zero[[j + 1]] <- numeric(n/2^j)
if (j != 1) {
for (k in (j - 1):1) zero[[k]] <- numeric(n/2^k)
}
x.mra[[j]] <- idwt(zero)
}
}
names(x.mra) <- c(paste("D", 1:J, sep = ""), paste("S", J,
sep = ""))
if (boundary == "reflection") {
for (j in (J + 1):1) x.mra[[j]] <- x.mra[[j]][1:(n/2)]
return(x.mra)
}
else {
return(x.mra)
}
}
###########################################
###########################################
# magnetic.latitude<-function(col=68.68,lam=202.00)
# magnetic.latitude<-function(col,lam)  
# {
# # returns cos of magnetic latitude used in Dst
# # (phi,lam)-geographic coord. of station 
# # (Phi,Lam)-geomagnetic coord. of station 
# # first convert to radii
# phi0<-79*2*pi/360
# lam0<-290*2*pi/360
# # phi<-(90-col)*2*pi/360
# phi<-(col)*2*pi/360
# lam<-lam*2*pi/360
# # lam<-lam
# Phi<-asin(sin(phi)*sin(phi0)+cos(phi)*cos(phi0)*cos(lam-lam0))
# Lambda<-asin(cos(phi)*sin(lam-lam0)/cos(Phi))
# list(Phi=Phi*360/(2*pi),Lambda=Lambda*360/(2*pi))
# #returns geomagnetic coordinates in degrees!!!
# }


#return a list with geomagnetic latitude and longitude [lat, long]
magnetic.coord<-function(col, lon, year){
  
  ref <- (year - 1900)/5 + 1
  
  PolesColLon<-read.table('gmCoord.txt')
  
  colNPol <- PolesColLon[,3][ref]
  phiNPol <- PolesColLon[,4][ref]
  col <- col*pi/180
  lon <- lon*pi/180
  
  phi0 <- phiNPol*pi/180
  col0 <- colNPol*pi/180

  Xg<-sin(col)*cos(lon)    
  Yg<-sin(col)*sin(lon)
  Zg<-cos(col)
  
  Xm<-Xg*(cos(phi0)*sin(col0+(pi/2)))+Yg*(sin(phi0)*sin(col0+(pi/2)))+Zg*(cos(col0+(pi/2)))
  Ym<-Xg*(sin((2*pi)-phi0))+Yg*(cos((2*pi)-phi0))
  Zm<-Xg*(cos(phi0)*sin(col0))+Yg*(sin(phi0)*sin(col0))+Zg*(cos(col0))
  
  V<-sqrt(Xm^2+Ym^2+Zm^2)
  
  Lam<-asin(Zm/V) #Geomagnetic Latitude
  
  Phi<-atan(Ym/Xm) #Geomagnetic Longitude
  
  geoCoord <- c(Lam, Phi)
  
  return(geoCoord)
  
}