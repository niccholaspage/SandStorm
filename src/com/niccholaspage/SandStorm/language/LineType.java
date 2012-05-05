package com.niccholaspage.SandStorm.language;

import com.niccholaspage.SandStorm.Phrase;

public enum LineType {
	VARIABLE_DECLARATION(Phrase.VARIABLE_DECLARATION),
	CALL(Phrase.CALL),
	IF(Phrase.IF);
	
	private final String startsWith;
	
	private LineType(Phrase phrase){
		this(phrase.toString());
	}
	
	private LineType(String startsWith){
		this.startsWith = startsWith;
	}
	
	public String getStartsWith(){
		return startsWith;
	}
	
	public static LineType getType(String line){
		for (LineType lineType : values()){
			if (line.startsWith(lineType.getStartsWith())){
				return lineType;
			}
		}
		
		return null;
	}
}
