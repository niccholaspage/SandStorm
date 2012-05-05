package com.niccholaspage.SandStorm.language.variables;

import com.niccholaspage.SandStorm.Phrase;
import com.niccholaspage.SandStorm.SandStorm;

public class VariableParser {
	private final String name;
	
	private Object value;
	
	public VariableParser(String line){
		int index = line.lastIndexOf(Phrase.DEFINE_SIGN.toString());

		name = line.substring(0, index);

		String stringValue = SandStorm.parseDoubleQuotations(line.substring(index + 1));
		
		if (SandStorm.isDebugging()){
			System.out.println("Variable Name: " + name);
			
			System.out.println("Variable Value: " + stringValue);
		}
		
		if (stringValue.equals("") || stringValue.equalsIgnoreCase("null")){
			stringValue = null;
		}
		
		try {
			value = Integer.parseInt(stringValue);
			
			if (SandStorm.isDebugging()){
				System.out.println("I'm an integer");
			}
		}catch (NumberFormatException e){
			value = stringValue;
			
			if (SandStorm.isDebugging()){
				System.out.println("I'm a string");
			}
		}
	}
	
	public String getName(){
		return name;
	}
	
	public Object getValue(){
		return value;
	}
}
