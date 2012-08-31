package com.mcorrigal.wordify;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private static final Map<Integer, String> INTEGER_DICTIONARY = new HashMap<Integer, String>();
	private static final Map<Integer, String> SPECIAL_INTEGER_PREPEND_DICTIONARY = new HashMap<Integer, String>();
	private static final Map<Integer, String> NUMBER_GROUP_APPENDAGE_DICTIONARY = new HashMap<Integer, String>();
	
	static {
		INTEGER_DICTIONARY.put(0, "zero");
		INTEGER_DICTIONARY.put(1, "one");
		INTEGER_DICTIONARY.put(2, "two");
		INTEGER_DICTIONARY.put(3, "three");
		INTEGER_DICTIONARY.put(4, "four");
		INTEGER_DICTIONARY.put(5, "five");
		INTEGER_DICTIONARY.put(6, "six");
		INTEGER_DICTIONARY.put(7, "seven");
		INTEGER_DICTIONARY.put(8, "eight");
		INTEGER_DICTIONARY.put(9, "nine");
		INTEGER_DICTIONARY.put(10, "ten");
		INTEGER_DICTIONARY.put(11, "eleven");
		INTEGER_DICTIONARY.put(12, "twelve");
		INTEGER_DICTIONARY.put(20, "twenty");
		
		SPECIAL_INTEGER_PREPEND_DICTIONARY.put(2, "twen");
		SPECIAL_INTEGER_PREPEND_DICTIONARY.put(3, "thir");
		SPECIAL_INTEGER_PREPEND_DICTIONARY.put(5, "fif");
		SPECIAL_INTEGER_PREPEND_DICTIONARY.put(8, "eigh");
		
		NUMBER_GROUP_APPENDAGE_DICTIONARY.put(2, " thousand");
		NUMBER_GROUP_APPENDAGE_DICTIONARY.put(3, " million");
		NUMBER_GROUP_APPENDAGE_DICTIONARY.put(4, " billion");
	}
	
	public static boolean integerTranslationExists(int value) {
		return INTEGER_DICTIONARY.containsKey(value);
	}
	
	public static String lookUpIntegerTranslation(int value) {
		return INTEGER_DICTIONARY.get(value);
	}
	
	public static boolean specialPrependTranslationExists(int value) {
		return SPECIAL_INTEGER_PREPEND_DICTIONARY.containsKey(value);
	}
	
	public static String lookUpSpecialPrependTranslation(int value) {
		return SPECIAL_INTEGER_PREPEND_DICTIONARY.get(value);
	}
	
	public static String lookUpNumberGroupAppendage(int value) {
		return NUMBER_GROUP_APPENDAGE_DICTIONARY.containsKey(value) ? NUMBER_GROUP_APPENDAGE_DICTIONARY.get(value) : "";
	}
	
}
