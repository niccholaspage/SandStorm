package com.niccholaspage.SandStorm.language;

import java.util.HashMap;
import java.util.Map;

import com.niccholaspage.SandStorm.language.function.Function;
import com.niccholaspage.SandStorm.language.function.functions.EchoFunction;

public class Constants {
	public final static String VARIABLE_DECLARATION = "var";
	public final static String CALL = "call";
	public final static String IF = "if";
	public final static String DEFINE_SIGN = "=";
	public final static String EQUALS = "==";
	public final static String OPEN_METHOD = "(";
	public final static String CLOSE_METHOD = ")";
	public final static String OPEN_BRACKET = "{";
	public final static String CLOSE_BRACKET = "}";
	public final static String ARGUMENT_SEPARATOR = ",";
	public final static String TRUE = "true";
	public final static String FALSE = "false";
	
	public static Map<String, Class<? extends Function>> functions;
	
	public static Map<String, Class<? extends Function>> getFunctions(){
		if (functions == null){
			functions = new HashMap<String, Class<? extends Function>>();
			
			functions.put("echo", EchoFunction.class);
		}
		
		return functions;
	}
	
	public static Class<? extends Function> getFunction(String name){
		for (String function : getFunctions().keySet()){
			if (function.equals(name)){
				return getFunctions().get(name);
			}
		}
		
		return null;
	}
}
