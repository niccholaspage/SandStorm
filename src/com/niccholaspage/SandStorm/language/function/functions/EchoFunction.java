package com.niccholaspage.SandStorm.language.function.functions;

import com.niccholaspage.SandStorm.language.function.Function;

public class EchoFunction implements Function {
	public void run(Object... functions){
		System.out.println("Herp!");
	}
}
