package com.niccholaspage.SandStorm;

import com.niccholaspage.SandStorm.language.Parser;

public class SandStorm {
	public SandStorm(){
		System.out.println("Welcome to SandStorm " + getVersion() + "! I shall now execute the test script.");
		
		String[] lines = new String[]{
				"var gabe = \"GABE NEWELL ROCKS\"",
				"var nick = \"NICK IS COOL\"",
				"var nick =",
		};
		
		new Parser(lines);
	}
	
	public static boolean isDebugging(){
		return true;
	}
	
	public static String getVersion(){
		return "0.1";
	}
	
	public static void main(String[] args){
		new SandStorm();
	}
}
