package com.niccholaspage.SandStorm.language;

import java.util.HashSet;
import java.util.Set;

import com.niccholaspage.SandStorm.SandStorm;
import com.niccholaspage.SandStorm.Validate;
import com.niccholaspage.SandStorm.language.function.Function;
import com.niccholaspage.SandStorm.language.function.FunctionParser;
import com.niccholaspage.SandStorm.language.variables.Variable;
import com.niccholaspage.SandStorm.language.variables.VariableParser;

public class Parser {
	private final String[] lines;

	private final Set<Variable> variables;

	public Parser(String[] lines){
		Validate.notNull(lines);

		this.lines = lines;

		variables = new HashSet<Variable>();

		try {
			run();
		} catch (ParseException e){
			e.printStackTrace();
		}
	}

	private void run() throws ParseException {
		int lineNumber = 0;

		for (String line : lines){
			Validate.notNull(line);
			
			if (line.startsWith("//")){
				continue;
			}

			lineNumber += 1;

			FixedLine fixedLine = fixLine(line, lineNumber);

			line = fixedLine.getLine();
			
			if (SandStorm.isDebugging()){
				System.out.println(line);
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

	private FixedLine fixLine(String line, int lineNumber) throws ParseException {
		String newLine = "";

		line = trimBeginningSpaces(line);

		LineType lineType = LineType.getType(line);

		if (lineType == null){
			throw new ParseException(lineNumber, "Invalid line type");
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

		newLine = newLine.trim();
		
		String variableLine = newLine + "";

		newLine = lineType.getStartsWith() + " " + newLine;

		if (newLine.replace(lineType.getStartsWith(), "").trim().equals("")){
			throw new ParseException(lineNumber, "Invalid line declaration");
		}

		if (lineType == LineType.VARIABLE_DECLARATION && variableLine.contains(Constants.EQUAL_SIGN)){
			VariableParser variableParser = new VariableParser(variableLine);
			
			Variable oldVariable = getVariable(variableParser.getName());
			
			if (oldVariable != null){
				variables.remove(oldVariable);
			}
			
			variables.add(new Variable(variableParser.getName(), variableParser.getValue()));
		}
		
		if (lineType == LineType.CALL){
			if (!(variableLine.contains(Constants.OPEN_METHOD) && variableLine.contains(Constants.CLOSE_METHOD))){
				throw new ParseException(lineNumber, "Invalid function call");
			}
			
			FunctionParser functionParser = new FunctionParser(variableLine);
			
			String name = functionParser.getFunction();
			
			Class<? extends Function> function = Constants.getFunction(name);
			
			if (function == null){
				throw new ParseException(lineNumber, "Function doesn't exist");
			}
			
			try {
				function.newInstance().run(functionParser.getArguments());
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		return new FixedLine(newLine, lineType);
	}

	public Set<Variable> getVariables(){
		return variables;
	}
	
	public Variable getVariable(String name){
		for (Variable variable : variables){
			if (variable.getName().equals(name)){
				return variable;
			}
		}
		
		return null;
	}
}
