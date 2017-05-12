package core.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EnvironmentSetup {

	private static EnvironmentSetup envir;
	private String ftpLogin;
	private String ftpPW;
	private String address;
	private EnvironmentSetup(){
		FileReader arq;
		try {
			arq = new FileReader("/home/raphael/workspace/geoanalysis/ftpsetup.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			this.setAddress(lerArq.readLine());
		     this.ftpLogin = lerArq.readLine();
		     this.ftpPW = lerArq.readLine();
		     arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	
	public static EnvironmentSetup getInstance(){
		if (envir==null) envir = new EnvironmentSetup();
		return envir;
	}

	public String getFtpLogin() {
		return ftpLogin;
	}

	public void setFtpLogin(String ftpLogin) {
		this.ftpLogin = ftpLogin;
	}

	public String getFtpPW() {
		return ftpPW;
	}

	public void setFtpPW(String ftpPW) {
		this.ftpPW = ftpPW;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
