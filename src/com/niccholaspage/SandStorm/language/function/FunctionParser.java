package com.niccholaspage.SandStorm.language.function;

import com.niccholaspage.SandStorm.SandStorm;
import com.niccholaspage.SandStorm.language.Constants;

public class FunctionParser {
	private final String function;
	
	public FunctionParser(String line){
		int index = line.lastIndexOf(Constants.OPEN_METHOD);

		function = line.substring(0, index);
		
		if (SandStorm.isDebugging()){
			System.out.println("Function Name: " + function);
		}
	}
	
	public String getFunction(){
		return function;
	}
}
