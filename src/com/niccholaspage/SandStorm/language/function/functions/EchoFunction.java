package com.niccholaspage.SandStorm.language.function.functions;

import com.niccholaspage.SandStorm.language.function.Function;

public class EchoFunction implements Function {
	public void run(Object... args){
		String message = "No argument passed!";
		
		if (args.length > 0 && args[0] instanceof String){
			message = (String) args[0];
		}
		
		System.out.println(message);
	}
}
