package com.niccholaspage.SandStorm.language;

import com.niccholaspage.SandStorm.SandStorm;
import com.niccholaspage.SandStorm.language.variables.Variable;

public class VariableParser {
	private final String name;
	
	private final Object value;
	
	public VariableParser(String line){
		int index = line.lastIndexOf(Constants.EQUAL_SIGN);

		name = line.substring(0, index);

		String value = line.substring(index + 1);
		
		if (SandStorm.isDebugging()){
			System.out.println("Variable Name: " + name);
			
			System.out.println("Variable Value: " + value);
		}
		
		if (value.equals("") || value.equalsIgnoreCase("null")){
			value = null;
		}
		
		this.value = value;
	}
	
	public Variable getVariable(){
		return new Variable(name, value);
	}
}
