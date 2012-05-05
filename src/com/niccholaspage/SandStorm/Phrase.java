package com.niccholaspage.SandStorm;

public enum Phrase {
	WELCOME_TO_SANDSTORM("Welcome to SandStorm $1! I shall now execute the test script."),
	VARIABLE_DECLARATION("var"),
	CALL("call"),
	IF("if"),
	DEFINE_SIGN("="),
	EQUALS("=="),
	OPEN_METHOD("("),
	CLOSE_METHOD(")"),
	OPEN_BRACKET("{"),
	CLOSE_BRACKET("}"),
	ARGUMENT_SEPARATOR(","),
	TRUE("true"),
	FALSE("false");

	private String defaultMessage;
	
	private String message;

	private Phrase(String defaultMessage){
		this.defaultMessage = defaultMessage;
		
		message = defaultMessage + "";
	}

	public void setMessage(String message){
		this.message = message;
	}

	private String getMessage(){
		return message;
	}
	
	public void reset(){
		message = defaultMessage + "";
	}
	
	public String getConfigName(){
		return name().toLowerCase();
	}
	
	public String parse(String... params){
		String parsedMessage = getMessage();

		if (params != null){
			for (int i = 0; i < params.length; i++){
				parsedMessage = parsedMessage.replace("$" + (i + 1), params[i]);
			}
		}

		return parsedMessage;
	}
	
	public String toString(){
		return parse();
	}
}