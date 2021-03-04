package com.jilit.clxacademics.response;

import java.util.HashMap;

import java.util.Map;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.BadRequestException;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;


@Service
public class RequestValidatorUtil {

	
	public Map isValidRequestBody(final Map<Object, Object> bodyMap, Map<Object, Object> keyMap)
	{
		Map map=new HashMap();
		String error="";
		boolean found=false;
		if(bodyMap==null||bodyMap.size()==0) {
			map.put("valid", "false");
			map.put("error", ErrorBank.ERROR_NULL_PARAMETERE_SUPPLIED);
		}
		for( Map.Entry<Object, Object> m:keyMap.entrySet()) {
			 found=false;
			for(Map.Entry<Object, Object> mm:bodyMap.entrySet())
			{
 			if(m.getKey() == mm.getKey()) {
				found=true;
				break;
			}
			}
			if( found==false) 
				{	if(error.isEmpty() || error.equalsIgnoreCase(""))
						error=ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED+ m.getKey(); 
					else 
						error=error+", " + m.getKey();
				}
		}
 
		if(error.equals(""))
		{
			map.put("valid", "true");
			map.put("error", "");
		}
		else
		{
			if(error.equals(""))
			{
				map.put("valid", "false");
				map.put("error", error);
			}
		}
		return map;
		
	}
	
	 


	
	public Map getResponseKeyValue ( final Map  bodyMap, String  keyitem) throws CLXException
	{
	//String keyitem="";
	Map map=new HashMap();
	boolean found=false;
	
	if(bodyMap==null||bodyMap.size()==0)
		{
			map.put("valid", "false");			
			map.put("error", ErrorBank.ERROR_NULL_PARAMETERE_SUPPLIED);
			throw new BadRequestException("RequestValidatorUtil",ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);			
			
		}
	else if (!bodyMap.containsKey(keyitem))
		{
		
			map.put("valid", "false");			
			map.put("error", ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			throw new BadRequestException("RequestValidatorUtil",ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
		}
	else
	{	
		
		String encryptedvalue=bodyMap.get(keyitem).toString();
		String decryptedvalue=encryptedvalue;// OLT Encryption in Future for selcted session items ie. meberid, membertype,userid,clientid
		map.put(keyitem,encryptedvalue);
	}
	
	
	
	return map;
	}
}
