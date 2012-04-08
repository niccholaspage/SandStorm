package com.niccholaspage.SandStorm;

import com.niccholaspage.SandStorm.language.Parser;

public class SandStorm {
	public SandStorm(){
		System.out.println("Welcome to SandStorm " + getVersion() + "! I shall now execute the test script.");
		
		String[] lines = new String[]{
				"var gabe = \"GABE NEWELL ROCKS\"",
				"var nick = \"NICK IS COOL\"",
				"var red = 9",
				"var blue =",
				"call echo()",
				"call echo(\"I like trains!\")"
		};
		
		new Parser(lines);
	}
	
	public static boolean isDebugging(){
		return true;
	}
	
	public static String getVersion(){
		return "0.1";
	}
	
	public static String parseDoubleQuotations(String line){
		if (line.startsWith("\"")){
			line = line.substring(1);
		}
		
		if (line.endsWith("\"")){
			line = line.substring(0, line.length() - 1);
		}
		
		return line;
	}
	
	public static void main(String[] args){
		new SandStorm();
	}
}
