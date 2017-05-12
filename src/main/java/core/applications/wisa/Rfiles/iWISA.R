###########################################
###########################################
###########################################
###########################################
###########################################
###########################################
# improved WISA
# data - data is a matrix or array where the 
# observations for each station are written in the columns
# wf - wavelet filter used for example "la8"
# n.levels - maxium level in analysis
# J0 - max level in thresholding
# J1 - max level in deseasonalizing
# boundary - boundary rule
# periods - periods used in deseasonalizing 
# you need as many periods specyfied as levels j=J0+1,...,J1 
#(typically 3)
#############################################################

# José P. Marchezi 18/03/2015 **

###########################################
# specify parameters of the wavelet analysis like in the paper
###########################################
#### for two months n.levels = 11##########
#n.levels<-11
#### for one year n.levels = 19 ##########
#n.levels<-19
# J0<-7
# J1<-10
# boundary<-"periodic"
# periods<-60*c(8,12,24)
# # quantile<-0.98
# wf="la8"
#================================================================

library(waveslim)

iWISA<-function(data, wf = wf, n.levels = n.levels, J0 = J0, J1 = J1, boundary = boundary, quantile = quantile)
{
# check if data is in the acceptable format
if(is.matrix(data)==F & is.array(data)==F& is.data.frame(data)==F) stop("wrong data format: input data should be matrix or array") else {

#N<-length(data)
n.station<-dim(data)[2] #each column of the data matrix are records for each individual station
N<-dim(data)[1]         # number of observations for each station

# if length of data >= one year, we have to
# decompose up to last level to remove the trend
if(N>=(365*1440)) n.levels<-floor(log(N,2))

# create the matrix to store data
preindex <- matrix(data = 0, ncol = n.station, nrow = N)

# MRA leveles used to extract periodic component
mra.sq <- matrix(data = 0, ncol = n.station, nrow = N)

# The following part constructs the part of the index, all except daily component part
#perform analysis for each line/station
for(i in 1:n.station){ 

# apply wavelet transform
data.wt <- modwt(data[, i], wf=wf, n.levels=n.levels, boundary=boundary)
#data.wt <- wavMODWT(data[, i], 'wf', n.levels=n.levels, keep.series=TRUE)

# levels in thresholding
which.levels<-1:J0

# threshold and change the name of the wavelet coeff. to
# emphasis that which.levels were shrinked, while others unchanged
data.wt.th<-quantile.manual.thresh.scalewise(data.wt, which.levels=which.levels, hard=FALSE, quantile=quantile)

# obtain MRA
data.wt.th.mra<-mra.wt(data.wt.th)

# prepare to reconstruct
data.recon<-numeric(N)
# add shrinked levels to data.recon
for(f in 1:J0) data.recon<-data.recon+data.wt.th.mra[[f]]

# MRA levels used to remove daily component
for(f in (J0+1):J1) mra.sq[,i] <- mra.sq[,i] + data.wt.th.mra[[f]]

# add remaining details
for(j in (J1+1):n.levels) data.recon<-data.recon+data.wt.th.mra[[j]]
                                                                
# compute the smooth
smooth<-data.wt.th.mra[[n.levels+1]]

# if length of data >= one year, replace smooth by its average
if(N>=(365*1440)) data.recon<-data.recon+mean(smooth)

# otherwise add unchanged smooth
if(N<(365*1440)) data.recon<-data.recon+smooth

preindex[,i]<-preindex[,i]+data.recon
}

# add deseasonalized levels, and compute Sq
# remove the daily component (pseudo-Sq)
# use the data from all stations
# vector to store pseudo-Sq component
deco<-rem.daily(mra.sq)

#preindex<-preindex+deco$recon
preindex<-preindex+deco

# recon - filtered data (matrix)
# pseudo.sq - estimated Sq
# smooth - smooth
#return(preindex = preindex, pseudo.sq = deco$SQ, smooth = smooth)
return(preindex = preindex)
#return(pseudo.sq = deco$SQ)
#return(smooth = smooth)


}
}
###########################################
###########################################
###########################################
