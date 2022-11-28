package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	
	public Map<String, String> defaultHeaders(){
		
		Map<String, String> defaultHeader = new HashMap<String, String>();
		defaultHeader.put("Content-Type", "application/json");
		
		return defaultHeader;
	}
	
	public Map<String, String> headersWithToken(){
		
		Map<String, String> defaultHeader = new HashMap<String, String>();
		defaultHeader.put("Content-Type", "application/json");
		defaultHeader.put("Acess-Token", "sdfaefasd");
		defaultHeader.put("jwt-token", "sdfaefasd");
		defaultHeader.put("Tenet-user", "test");
		
		return defaultHeader;
	}
}
