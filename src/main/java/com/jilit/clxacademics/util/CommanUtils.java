package com.jilit.clxacademics.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.exceptions.EntityNotFoundException; 
import com.jilit.clxacademics.model.Sct_IrpMlp; 

@Component
public class CommanUtils {

	 

	public String getIPadress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getMacAddress() throws UnknownHostException, SocketException {
		InetAddress ipAddress = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
		byte[] macAddressBytes = networkInterface.getHardwareAddress();
		StringBuilder macAddressBuilder = new StringBuilder();

		for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++) {
			String macAddressHexByte = String.format("%02X", macAddressBytes[macAddressByteIndex]);
			macAddressBuilder.append(macAddressHexByte);

			if (macAddressByteIndex != macAddressBytes.length - 1) {
				macAddressBuilder.append(":");
			}
		}

		return macAddressBuilder.toString();
	}

	public Map nullifyMap(Map<Object, Object> infoMap) throws CLXException {

		for (Map.Entry m : infoMap.entrySet()) {
			// checking each value in map whether null or not
			if ((m.getValue() == null)
					|| (m.getValue() instanceof String && ((String) m.getValue()).equalsIgnoreCase("NULL"))) {
				 
				infoMap.put(m.getKey(), "");// in case value of any key is found null
			} else if (m.getValue() == null
					&& m.getValue() instanceof BigDecimal ) {
				infoMap.put(m.getKey(), new BigDecimal(0));// in case value of any key is found null
			} else if (m.getValue() == null
					&& m.getValue() instanceof Integer ) {
				infoMap.put(m.getKey(), new Integer(0));// in case value of any key is found null
			}
		}
		return infoMap;// maps all the values with respective keys and return map
	}

	 
 	 
}
