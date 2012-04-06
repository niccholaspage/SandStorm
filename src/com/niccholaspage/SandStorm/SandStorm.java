package com.niccholaspage.SandStorm;

import com.niccholaspage.SandStorm.language.Parser;

public class SandStorm {
	private final static String version = "0.1";
	
	public static String getVersion(){
		return version;
	}
	
	public static void main(String[] args){
		String[] lines = new String[]{
				"var gabe = \"GABE NEWELL ROCKS\";",
		};
		
		new Parser(lines);
	}
}
