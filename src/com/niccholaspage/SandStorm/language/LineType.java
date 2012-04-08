package com.niccholaspage.SandStorm.language;

public enum LineType {
	VARIABLE_DECLARATION(Constants.VARIABLE_DECLARATION),
	CALL(Constants.CALL),
	IF(Constants.IF);
	
	private final String startsWith;
	
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
