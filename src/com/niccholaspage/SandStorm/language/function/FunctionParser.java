package com.niccholaspage.SandStorm.language.function;

import com.niccholaspage.SandStorm.SandStorm;
import com.niccholaspage.SandStorm.language.Constants;

public class FunctionParser {
	private final String function;
	
	private final Object[] arguments;
	
	public FunctionParser(String line){
		int openIndex = line.lastIndexOf(Constants.OPEN_METHOD);

		function = line.substring(0, openIndex);
		
		if (SandStorm.isDebugging()){
			System.out.println("Function Name: " + function);
		}
		
		int closeIndex = line.lastIndexOf(Constants.CLOSE_METHOD);
		
		String unparsedArgs = line.substring(openIndex + 1, closeIndex);
		
		if (SandStorm.isDebugging()){
			System.out.println("Unparsed Arguments: " + unparsedArgs);
		}
		if (!unparsedArgs.isEmpty()){
			String[] args = unparsedArgs.split(Constants.ARGUMENT_SEPARATOR);
			
			for (int i = 0; i < args.length; i++){
				args[i] = SandStorm.parseDoubleQuotations(args[i]);
			}
			
			if (SandStorm.isDebugging()){
				for (String arg : args){
					System.out.println("Parsed Argument: " + arg);
				}
			}
			
			arguments = args;
		}else {
			arguments = new String[0];
		}
	}
	
	public String getFunction(){
		return function;
	}
	
	public Object[] getArguments(){
		return arguments;
	}
}
