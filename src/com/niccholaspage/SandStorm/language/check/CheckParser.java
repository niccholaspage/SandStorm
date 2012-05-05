package com.niccholaspage.SandStorm.language.check;

import com.niccholaspage.SandStorm.Phrase;

public class CheckParser {
	private final boolean bool;
	
	public CheckParser(String line){
		int openIndex = line.lastIndexOf(Phrase.OPEN_METHOD.toString());
		
		int closeIndex = line.lastIndexOf(Phrase.CLOSE_METHOD.toString());
		
		String check = line.substring(openIndex + 1, closeIndex);
		
		if (check.equalsIgnoreCase(Phrase.TRUE.toString()) || check.equalsIgnoreCase(Phrase.FALSE.toString())){
			bool = check.equals(Phrase.TRUE.toString());
			
			return;
		}
		
		bool = true;
	}
	
	public boolean getBoolean(){
		return bool;
	}
}
