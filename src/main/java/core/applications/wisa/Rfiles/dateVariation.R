library(lubridate)
dateVariation <- function(dIni, dFinal){
	#dInit <- as.Date(dinit)
	#dFinal <- as.Date(dfinal)

	variation <- interval(ymd(dIni), ymd(dFinal))
	min <- as.numeric(variation, "minutes")
	hours <- 0
	minutes <- 0
	p = 0
  abc = c()
	for(i in 0:min){
		p <- p+1
		minutes <- minutes + 1
		if(minutes >= 60){
			hours <- hours + 1
			minutes <- 0
			if(hours >= 24){
			  hours <- 0
				dIni <- dIni + 1
			}
		}
		abc[p] <- paste(dIni," ",formatC(hours, width=2, flag="0"),":",formatC(minutes, width=2, flag="0"), ":00", sep = "")
		}
	 return (abc)
}
