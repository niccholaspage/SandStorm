package com.niccholaspage.SandStorm.language;

import java.util.HashMap;
import java.util.Map;

import com.niccholaspage.SandStorm.language.function.Function;
import com.niccholaspage.SandStorm.language.function.functions.EchoFunction;

public class Constants {
	public static Map<String, Class<? extends Function>> functions;
	
	public static Map<String, Class<? extends Function>> getFunctions(){
		return functions;
	}
	
	public static Class<? extends Function> getFunction(String name){
		for (String function : functions.keySet()){
			if (function.equals(name)){
				return functions.get(name);
			}
		}
		
		return null;
	}
	
	static {
		functions = new HashMap<String, Class<? extends Function>>();
		
		functions.put("echo", EchoFunction.class);
	}
}
