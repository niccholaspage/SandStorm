package com.niccholaspage.SandStorm.language;

@SuppressWarnings("serial")
public class ParseException extends Exception {
	private final int line;
	
	public ParseException(int line){
		this.line = line;
	}
	
	@Override
	public String getMessage(){
		return "Error at line " + line;
	}
}
