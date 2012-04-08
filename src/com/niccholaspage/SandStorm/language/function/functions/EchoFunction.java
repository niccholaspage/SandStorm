package com.niccholaspage.SandStorm.language.function.functions;

import com.niccholaspage.SandStorm.language.function.Function;

public class EchoFunction implements Function {
	public void run(Object... functions){
		String message = "No argument passed!";
		
		if (functions.length > 0 && functions[0] instanceof String){
			message = (String) functions[0];
		}
		
		System.out.println(message);
	}
}
