package com.niccholaspage.SandStorm.language;

@SuppressWarnings("serial")
public class ParseException extends Exception {
	private final int line;
	
	private final String error;
	
	public ParseException(int line, String error){
		this.line = line;
		
		this.error = error;
	}
	
	public String getMessage(){
		return "Error at line " + line + ": " + error;
	}
}
