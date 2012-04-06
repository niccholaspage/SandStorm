package com.niccholaspage.SandStorm.language;

import java.util.HashSet;
import java.util.Set;

import com.niccholaspage.SandStorm.Validate;
import com.niccholaspage.SandStorm.language.variables.Variable;

public class Parser {
	private final String[] lines;
	
	private final Set<Variable> variables;
	
	public Parser(String[] lines){
		Validate.notNull(lines);
		
		this.lines = lines;
		
		variables = new HashSet<Variable>();
		
		try {
			parse();
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
	private void parse() throws ParseException {
		int lineNumber = 0;
		
		for (String line : lines){
			Validate.notNull(line);
			
			lineNumber += 1;
			
			FixedLine fixedLine = fixLine(line, lineNumber);
			
			line = fixedLine.getLine();
			
			System.out.println(line);
		}
	}
	
	private String trimBeginningSpaces(String line){
		if (!line.startsWith(" ")){
			return line;
		}
		
		String newLine = "";
		
		int i = 0;
		
		for (i = 0; i < line.length(); i++){
			if (line.charAt(i) != ' '){
				break;
			}
		}
		
		newLine = line.substring(i);
		
		return newLine;
	}
	
	private FixedLine fixLine(String line, int lineNumber) throws ParseException {
		String newLine = "";
		
		line = trimBeginningSpaces(line);
		
		LineType lineType = LineType.getType(line);
		
		if (lineType == null){
			throw new ParseException(lineNumber);
		}
		
		boolean removeSpaces = true;
		
		String arrayLine = line.replace(lineType.getStartsWith(), "");
		
		for (char character : arrayLine.toCharArray()){
			if (character == '"'){
				removeSpaces = !removeSpaces;
			}
			
			if (character == ' ' && removeSpaces){
				continue;
			}
			
			newLine += character;
		}
		
		newLine = lineType.getStartsWith() + " " + newLine.trim();
		
		if (newLine.replace(lineType.getStartsWith(), "").trim().equals("")){
			throw new ParseException(lineNumber);
		}
		
		return new FixedLine(newLine, lineType);
	}
	
	public Set<Variable> getVariables(){
		return variables;
	}
}
