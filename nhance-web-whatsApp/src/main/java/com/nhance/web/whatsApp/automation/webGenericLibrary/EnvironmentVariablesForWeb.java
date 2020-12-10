package com.nhance.web.whatsApp.automation.webGenericLibrary;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnvironmentVariablesForWeb {
	
	private static Map<String, Object> environmentPropertyMap = new HashMap<String, Object>();
	
	public static void setEnvironmentPropertyMap(Map<String, Object> environmentPropertyMap) {
		EnvironmentVariablesForWeb.environmentPropertyMap = environmentPropertyMap;
	}
	
	public static Object getPropertyValue(String propertyName) {
		return environmentPropertyMap.get(propertyName);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static Object getPropertyValue(List<String> propertyName) {
		return environmentPropertyMap.get(propertyName);
	}
	
	public static Object getPropertyValue(boolean propertyName) {
		return environmentPropertyMap.get(propertyName);
	}
	
	public static Object getPropertyValue(Path propertyName) {
		return environmentPropertyMap.get(propertyName);
	}
	
	public static Map<String, Object> getEnvironmentPropertyMap () {
		return environmentPropertyMap;
	}
	
	
}
