package com.mcorrigal.wordify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSplitter {
	
	private static final int NUMBER_GROUP_SIZE = 3;

	public List<Integer> splitUp(int number) {
		String numberString = String.valueOf(number);
		List<String> numberGroups = new ArrayList<String>();
		while (numberString != null) {
			int length = numberString.length();
			
			if (length <= NUMBER_GROUP_SIZE) {
				numberGroups.add(numberString);
				numberString = null;
			} else {
				numberGroups.add(getRightMostGroupOfThree(numberString));
				numberString = stripLastGroupOfThree(numberString);
			}
		}
		Collections.reverse(numberGroups);
		return convertToIntegerList(numberGroups);
	}
	
	private String getRightMostGroupOfThree(String numbString) {
		return numbString.substring(numbString.length() - NUMBER_GROUP_SIZE);
	}
	
	private String stripLastGroupOfThree(String numbString) {
		return numbString.substring(0, numbString.length() - NUMBER_GROUP_SIZE);
	}
	
	private List<Integer> convertToIntegerList(List<String> stringList) {
		List<Integer> intList = new ArrayList<Integer>();
		for (String string : stringList) {
			intList.add(Integer.valueOf(string));
		}
		return intList;
	}
	
}
