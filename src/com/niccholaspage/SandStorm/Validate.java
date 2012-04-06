package com.niccholaspage.SandStorm;

public class Validate {
	public static void notNull(Object object){
		if (object == null){
			throw new IllegalArgumentException();
		}
	}
}
