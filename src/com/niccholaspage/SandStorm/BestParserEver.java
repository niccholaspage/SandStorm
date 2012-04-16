package com.niccholaspage.SandStorm;

import com.niccholaspage.SandStorm.language.Parser;

public class BestParserEver extends Parser {

	public BestParserEver(String[] lines){
		super(lines);
		
		addFunction("derp", DerpFunction.class);
	}
}
