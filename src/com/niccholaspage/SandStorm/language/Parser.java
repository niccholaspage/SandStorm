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
			lineNumber += 1;
			
			line = fixLine(line, lineNumber);
			
			System.out.println(line);
			
			if (line.startsWith(Constants.VARIABLE_DECLARATION)){
				if (line.replace(Constants.VARIABLE_DECLARATION, "").equals("")){
					throw new ParseException(lineNumber);
				}
				
				/*if (line.contains(Constants.EQUAL_SIGN)){
					String value = line.replace(Constants.VARIABLE_DECLARATION + Constants.EQUAL_SIGN, "");
					
					variables.add(new Variable())
				}*/
			}
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
	
	private String fixLine(String line, int lineNumber) throws ParseException {
		String newLine = "";
		
		line = trimBeginningSpaces(line);
		
		LineType lineType = LineType.getType(line);
		
		if (lineType == null){
			throw new ParseException(lineNumber);
		}
		
		System.out.println(lineType.name());
		
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
		
		return newLine;
	}
}
