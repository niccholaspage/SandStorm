package com.niccholaspage.SandStorm.language;

public class FixedLine {
	private final String line;
	
	private final LineType lineType;
	
	public FixedLine(String line, LineType lineType){
		this.line = line;
		
		this.lineType = lineType;
	}
	
	public String getLine(){
		return line;
	}
	
	public LineType getLineType(){
		return lineType;
	}
}
