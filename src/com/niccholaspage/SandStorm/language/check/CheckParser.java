package com.niccholaspage.SandStorm.language.check;

import com.niccholaspage.SandStorm.language.Constants;

public class CheckParser {
	private final boolean bool;
	
	public CheckParser(String line){
		int openIndex = line.lastIndexOf(Constants.OPEN_METHOD);
		
		int closeIndex = line.lastIndexOf(Constants.CLOSE_METHOD);
		
		String check = line.substring(openIndex + 1, closeIndex);
		
		if (check.equalsIgnoreCase(Constants.TRUE) || check.equalsIgnoreCase(Constants.FALSE)){
			bool = check.equals(Constants.TRUE);
			
			return;
		}
		
		bool = true;
	}
	
	public boolean getBoolean(){
		return bool;
	}
}
