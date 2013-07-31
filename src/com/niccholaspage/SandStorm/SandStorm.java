package com.niccholaspage.SandStorm;

public class SandStorm {
	public SandStorm(){
		System.out.println(Phrase.WELCOME_TO_SANDSTORM.parse(getVersion()));
		
		String[] lines = new String[]{
				"var gabe = \"GABE NEWELL ROCKS\"",
				"var nick = \"NICK IS COOL\"",
				"var red = 9",
				"var blue =",
				"call echo()",
				"call echo(\"Time for a variable test!\")",
                "call echo(\"nick\")",
				"call derp()"
		};
		
		new BestParserEver(lines).run();
	}
	
	public final static boolean isDebugging(){
		return false;
	}
	
	public static String getVersion(){
		return "0.1";
	}
	
	public static String parseDoubleQuotations(String line){
		if (line.startsWith(Phrase.DOUBLE_QUOTE.toString())){
			line = line.substring(1);
		}
		
		if (line.endsWith(Phrase.DOUBLE_QUOTE.toString())){
			line = line.substring(0, line.length() - 1);
		}
		
		return line;
	}
	
	public static void main(String[] args){
		new SandStorm();
	}
}
