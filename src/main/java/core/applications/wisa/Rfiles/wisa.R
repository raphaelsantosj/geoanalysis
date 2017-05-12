# wisa.R
# Análise Wavelet I
# José Paulo Marchezi

J0<-7
J1<-10
boundary<-"reflection"
periods<-60*c(8,12,24)
quantile<-0.98
wf="la8"

data<-read.table("dadoscompH.dat")

n.station<-dim(data)[2] 
N<-dim(data)[1]

for (i in seq(1,n.station)) {
	for (k in seq(1,)){
 		sumN2<-N
 		SumData2<-sum(data[k,i])
 		Somad1<-SumData2/sumN2
 		data[k,i]<-data[k,i]-Somad1
 	}
}

for (k in seq(1,N)) {
	for (i in seq(1,n.station)){
 		sumN2<-n.station
 		SumData1<-sum(data[k,i])
 		Somad2<-SumData1/sumN2;
 		data[k,i]<-Somad2
 	}
}

if(N>=(365*1440)) n.levels<-floor(log(N,2))

preindex <- matrix(data = 0, ncol = n.station, nrow = N)

mra.sq <- matrix(data = 0, ncol = n.station, nrow = N)

for(i in 1:n.station){

	data.wt <- modwt(data[, i], wf=wf, n.levels=n.levels, boundary=boundary)

	which.levels<-1:J0

  
  #threshold
	data.wt.th<-quantile.manual.thresh.scalewise(data.wt,which.levels=which.levels, hard=FALSE, quantile=quantile)	
	
  data.wt.th.mra<-mra.wt(data.wt.th)

	data.recon<-numeric(N)
	for(f in 1:J0) data.recon<-data.recon+data.wt.th.mra[[f]]

	for(f in (J0+1):J1) mra.sq[,i] <- mra.sq[,i] + data.wt.th.mra[[f]]

	for(j in (J1+1):n.levels) data.recon<-data.recon+data.wt.th.mra[[j]]

	smooth<-data.wt.th.mra[[n.levels+1]]

	if(N>=(365*1440)) data.recon<-data.recon+mean(smooth)

	if(N<(365*1440)) data.recon<-data.recon+smooth

	preindex[,i]<-preindex[,i]+data.recon
}

	deco<-rem.daily(mra.sq)

	preindex<-preindex+deco

	return(preindex = preindex)