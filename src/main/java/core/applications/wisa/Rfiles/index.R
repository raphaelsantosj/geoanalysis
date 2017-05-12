# the whole procedure that constructs a storm activity index

# Edited by José P. Marchezi 18/03/2015 **

source("iWISA.R")
source("pca_sq.R")
source("dailycomp.R")
source("routines.R")

###########################################
# specify parameters of the wavelet analysis like in the paper
###########################################
#### for two months n.levels = 11##########
#n.levels<-11
#### for one year n.levels = 19 ##########
#n.levels<-19

# **
#**

# n.station<-dim(data)[2] #each column of the data matrix are records for each individual station
# N<-dim(data)[1]         # number of observations for each station



wf="la8"

SAIndex<-function(data, coord, wf=wf){
  
###########################################
# filter each Dst station and adjust for the magnetic latitude and 
# subtract the average
###########################################
# J0<-7
# J1<-10
boundary<-"periodic"
periods<-60*c(8,12,24)
quantile<-0.98

SAI<-iWISA(data, wf = wf, n.levels = n.levels, J0 = J0, J1 = J1, 
            boundary = boundary, quantile = quantile) 
n.station<-dim(data)[2] #each column of the data matrix are records for each individual station

N<-dim(data)[1]         # number of observations for each station




index<-matrix(0, ncol=n.station, nrow=N)
final.index<-matrix(0, ncol=n.station, nrow=N)

# **

# make latitude adjustment.
for(i in 1:4){

  index[,i]<-SAI[,i]/cos(magnetic.coord(coord[1,i],coord[2,i], year)[1]) 

}

# **

# center: subtract the mean
for(i in 1:4){
final.index[,i]<-index[,i]-mean(index[,i])
# final.index[,i]<-index[,i]
#final.index[,i]<-mean(index[,i])
}
###########################################


#SI<-final.index
SI<-numeric(N)
SI<-apply(final.index, 1, mean)

#return(SI=SI, p.SQ=SAI$pseudo.sq)
return(SI=SI)
return(p.SQ=SAI$pseudo.sq)

}
