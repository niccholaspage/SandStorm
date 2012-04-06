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
			
			line = line.trim();
			
			if (line.startsWith("var ")){
				if (line.replace("var ", "").equals("")){
					throw new ParseException(lineNumber);
				}
			}
		}
	}
}
