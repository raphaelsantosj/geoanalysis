#=================================================================
# Function that removes daily periodic component.
# Returns: 1. storm activity
#          2. pseudo-Sq component (better alternative is available
#             see. SQ function of this package)
#=================================================================
rem.daily<-function(data){
#==================================================================
n.station<-dim(data)[2] # each column of the data matrix are records for each individual station
N<-dim(data)[1]         # number of observations for each station
# matrix to store results
recon<-matrix(0, ncol = n.station, nrow = N)
#
# vector: average of all stations' records
mean.v<-numeric(N)
if(n.station==1) mean.v<-numeric(N) else mean.v<-apply(data, 1, mean)
#
# prepare to remove mean
data.centr<-matrix(NA, ncol=n.station, nrow = N)
#
# remove pointwise mean of all stations
for(i in 1:n.station){data.centr[,i]<-data[,i] - mean.v}
#   
# remove periodic component
deco<-pca.sq(data.centr)
#
# Pseudo-Sq component
SQ <- deco$sq
for(i in 1:n.station) recon[,i] <- deco$diff[,i] + mean.v
#
#return(recon = recon, SQ = SQ)
return(recon=recon)
return(SQ=SQ)
}
