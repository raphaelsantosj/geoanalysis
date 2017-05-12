/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.ftp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpConnection {
	FTPClient ftp;
	private String FTPlink;
	private String FTPuser;
	private String FTPpassword;
	private String dir; //Directory Class
	private List<String> obs= new LinkedList<String>();


	public FtpConnection(String FTPlink, String FTPuser, String FTPpassword){
		this.ftp = new FTPClient();
		this.FTPlink = FTPlink;
		this.FTPuser = FTPuser;
		this.FTPpassword = FTPpassword;
		//ADD SYM-H Observatories
		obs.add("frd");
		obs.add("bou");
		obs.add("tuc");
		obs.add("mmb");
		obs.add("wmq");
		obs.add("kak");
		obs.add("abg");
		obs.add("ams");
		obs.add("clf");
		obs.add("her");
		obs.add("hon");
		obs.add("sjg");
		
	}
	
	//FOR INTERMAGNET
	@SuppressWarnings("deprecation")
	public void setDir(String dInt) throws IOException{
		Date d = new Date();
		Integer year = d.getYear()+1900;
		Integer month = d.getMonth()+1;
		//Def interval
		String minORsec;
		if (dInt.equals("s")) minORsec = "second";
		else minORsec = "minute";
		//Def Month
		if (d.getDate() == 1) month--; //Verify if day == 1 
		String fMonth;
		if (month<10) fMonth = "0"+month;
		else fMonth = Integer.toString(month);
		this.dir = "/"+minORsec+"/provisional"+"/IAGA2002/"+year+"/"+fMonth;	
		this.ftp.changeWorkingDirectory(this.dir);
	}
	
	public List<String> getFile(String fileName) throws Exception{
		if (fileName.contains("min")) return getFileMin(fileName);
		else return getFileSec(fileName);
	}
	
	//Get minutes files
	private List<String> getFileMin(String fileName) throws Exception{
			this.connect();
			this.setDirByFile(fileName);
			this.ftp.setFileType(FTP.ASCII_FILE_TYPE);
			BufferedReader reader;
			System.out.println(fileName);
			try{
				reader = new BufferedReader( new InputStreamReader(this.ftp.retrieveFileStream(fileName)));
				List<String> arq = new LinkedList<String>();
				String linha = "";
				arq.add("min");
				arq.add(fileName.substring(0, 3));
				while((linha = reader.readLine()) != null) arq.add(linha + " " + fileName.substring(0, 3));
				this.disconnect();
				return arq;	
			}
			catch(NullPointerException e){
				e.printStackTrace();
				this.disconnect();
				return null;
			}	
	}
	
	//Get seconds files (with GZIP)
	private List<String> getFileSec(String fileName) throws Exception{
			this.connect();
			this.setDirByFile(fileName);
			this.ftp.setFileType(FTP.BINARY_FILE_TYPE);
			List<String> arq = new LinkedList<String>();
			byte[] buffer = new byte[1024];
			StringBuilder sb = new StringBuilder();
			try{
				InputStream in2 = ftp.retrieveFileStream(fileName);
				GZIPInputStream gzis = new GZIPInputStream(in2);	
				for (int length = 0; (length = gzis.read(buffer)) > 0;) {
					 String s = new String(buffer, 0, length);
					 sb.append(s);		        	
				}
				gzis.close(); 
				arq.add("sec");
				arq.add(fileName.substring(0, 3));
				for (String linha: sb.toString().split("[\\r\\n]+")){
					arq.add(linha + " " + fileName.substring(0, 3));
				}
				this.disconnect();
				return arq;
			}
			catch(NullPointerException e){
				e.printStackTrace();
				this.disconnect();
				return null;
			}
	}
	
	//WILL SET THE DIRECTORY USING A FILE NAME ex:(her22101990pmin.min)
	public void setDirByFile(String fileName) throws IOException{
		String mORs = fileName.substring(12, 15);
		String fileYear = fileName.substring(3, 7);
		String fileMonth = fileName.substring(7, 9);
		String minuteORsecond;
		if (mORs.equals("min")) minuteORsecond = "minute";
		else minuteORsecond = "second";
		this.dir = "/"+minuteORsecond+"/provisional"+"/IAGA2002/"+fileYear+"/"+fileMonth;
		this.ftp.changeWorkingDirectory(this.dir);
		
	}
	
	//THIS METHOD WILL GET A FILE LIST OF SYM-H OBSERVATORIES
	public List<String> getFileList() throws IOException{
		List<String> lFiles = new LinkedList<String>();
		FTPFile[] files = this.ftp.listFiles();
		for (FTPFile a: files){
			if (this.obs.contains(a.getName().substring(0, 3))){ 
				lFiles.add(a.getName());
			}
		}
		System.out.println("getFileList");
		return lFiles;
	}	
	


	public void connect(){
		try {
			this.ftp.connect(this.FTPlink);
			this.ftp.enterLocalPassiveMode();
			this.ftp.login(this.FTPuser, this.FTPpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() throws IOException{
		this.ftp.disconnect();
	}
}

