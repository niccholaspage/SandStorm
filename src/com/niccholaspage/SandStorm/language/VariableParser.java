package com.niccholaspage.SandStorm.language;

import com.niccholaspage.SandStorm.SandStorm;
import com.niccholaspage.SandStorm.language.variables.Variable;

public class VariableParser {
	private final String name;
	
	private Object value;
	
	public VariableParser(String line){
		int index = line.lastIndexOf(Constants.EQUAL_SIGN);

		name = line.substring(0, index);

		String stringValue = line.substring(index + 1);
		
		if (SandStorm.isDebugging()){
			System.out.println("Variable Name: " + name);
			
			System.out.println("Variable Value: " + stringValue);
		}
		
		if (stringValue.equals("") || stringValue.equalsIgnoreCase("null")){
			stringValue = null;
		}
		
		try {
			value = Integer.parseInt(stringValue);
		}catch (NumberFormatException e){
			value = stringValue;
		}
	}
	
	public Variable getVariable(){
		return new Variable(name, value);
	}
}
