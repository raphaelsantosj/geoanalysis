/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.services;

import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import org.json.JSONArray;

public class CacheService {
	
	private static CacheService cs;
	private Map <String, JSONArray> hdzCache = new HashMap<String, JSONArray>();
	private Map <String, JSONArray> wisaCache = new HashMap<String, JSONArray>();
	private String wisaToday = "";
	private Date wisadIniNow;
	private Date wisadFinalNow;

	private CacheService(){
		
	}
	
	public static CacheService getInstance(){
		if (cs==null) cs = new CacheService();
		return cs;
	}
	
	public Map<String, JSONArray> getHdzCache() {
		return hdzCache;
	}

	public Map<String, JSONArray> getWisaCache() {
		return wisaCache;
	}

	public Date getWisadIniNow() {
		return wisadIniNow;
	}

	public void setWisadIniNow(Date wisadIniNow) {
		this.wisadIniNow = wisadIniNow;
	}

	public Date getWisadFinalNow() {
		return wisadFinalNow;
	}

	public void setWisadFinalNow(Date wisadFinalNow) {
		this.wisadFinalNow = wisadFinalNow;
	}

	public String getWisaToday() {
		return wisaToday;
	}

	public void setWisaToday(String wisaToday) {
		this.wisaToday = wisaToday;
	}


}
