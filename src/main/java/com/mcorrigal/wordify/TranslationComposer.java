package com.mcorrigal.wordify;

import static com.mcorrigal.wordify.Dictionary.lookUpNumberGroupAppendage;

import java.util.List;

public class TranslationComposer {

	private NumberSplitter numberSplitter = new NumberSplitter();
	private NumberGroupTranslator numberGroupTranslator = new NumberGroupTranslator();
	private StringBuilder composition;
	private List<Integer> numberGroups;
	
	public String composeTranslationFor(int number) {
		composition = new StringBuilder();
		numberGroups = numberSplitter.splitUp(number);
		
		int remainingNumberGroups = numberGroups.size();
		
		if (number < 0) composition.append("minus ");
		
		for (int i = 0; i < numberGroups.size(); i++) {
			
			int currentNumberGroup = numberGroups.get(i);
			String appendage = getAppendageForNumberGroup(remainingNumberGroups);
			remainingNumberGroups --;
			
			if (groupDoesNotEquateToZero(currentNumberGroup)) {
				
				if (number > 100 && remainingNumberGroups == 0 && currentNumberGroup < 100) {
					appendToComposition(" and " + translateNumberGroup(currentNumberGroup));
					
				} else {
					appendToComposition(translateNumberGroup(currentNumberGroup));
					appendToComposition(appendage);
					
					if (remainingNumberGroups > 0) {
						if (nextNumberGroup(i) > 99 || (groupDoesNotEquateToZero(nextNumberGroup(i)) && remainingNumberGroups > 1)) {
							appendToComposition(", ");
						}
					}
				}
			}
		}
		
		return composition.toString();
	}

	private Integer nextNumberGroup(int currentIndex) {
		return numberGroups.get(currentIndex + 1);
	}
	
	private void appendToComposition(String text) {
		composition.append(text);
	}
	
	private String translateNumberGroup(int numberGroup) {
		return numberGroupTranslator.translate(numberGroup);
	}
	
	private String getAppendageForNumberGroup(int numberOfGroups) {
		return lookUpNumberGroupAppendage(numberOfGroups);
	}
	
	private boolean groupDoesNotEquateToZero(int numberGroup) {
		return numberGroup == 0 ? false : true;
	}

}
