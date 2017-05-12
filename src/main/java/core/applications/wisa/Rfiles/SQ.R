# SQ.new estimates the SQ component (non-constant)


# First compute storm index for the data set (separately), then use it to find the SQ
#si.v<-numeric(N)
#si.v<-SAIndex(data.r, coord.r, wf="la8")$SI

SQ.new<-function(data, si.v=si.v, wf = "la8", n.levels = 10, boundary = "reflection",
            quantile=0.98){
J0<-7
J1<-10
if(is.vector(data)==T) {n.station<-1
                        N<-length(data)} else {n.station<-dim(data)[2] #each column of the data matrix are records for each individual station
N<-dim(data)[1]}         # number of observations for each station
library(waveslim)
data.ds<-matrix(NA, ncol=n.station, nrow = N)
# remove the storm activity from all stations
for(i in 1:n.station){data.ds[,i]<-data[,i] - si.v}
mra.sq <- matrix(data = 0, ncol = n.station, nrow = N)
for(i in 1:n.station){ 
# obtain MRA from the data after storm activity was removed
    data.mra<-mra(data.ds[,i], wf=wf, J = n.levels, boundary=boundary)
# MRA leveles used to extract periodic component
for(f in (J0+1):J1) mra.sq[,i] <- mra.sq[,i] + data.mra[[f]]
}
# extract periodic component
deco<-pca.SQ.new(mra.sq)
# Sq component
SQ <- deco$sq
return(SQ)
}
