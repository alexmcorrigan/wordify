package com.mcorrigal.wordify;

import java.util.List;

public class TranslationComposer {

	private NumberSplitter numberSplitter = new NumberSplitter();
	private NumberGroupTranslator numberGroupTranslator = new NumberGroupTranslator();
	private StringBuilder composition;
	private NumberGroupCollection numberGroups;
	
	public String composeTranslationFor(int number) {
		composition = new StringBuilder();
		numberGroups = new NumberGroupCollection();
		
		List<Integer> numberGroupValues = numberSplitter.splitUp(number);
		for (int i = 0; i < numberGroupValues.size(); i++) {
			numberGroups.add(numberGroupTranslator.translate(numberGroupValues.get(i), numberGroupValues.size(), i));
		}
		
		while (numberGroups.hasNext()) {
			NumberGroup currentNumberGroup = numberGroups.next();
			numberGroups.remove();
			
			if (currentNumberGroup.isNotZero()) {
				
				if (number > 100 && numberGroups.size() == 0 && currentNumberGroup.isLessThan(100)) {
					appendToComposition(" and "); 
					appendToComposition(currentNumberGroup.getNumberGroupTranslation());
				} else {
					appendToComposition(currentNumberGroup.getNumberGroupTranslation());
					appendToComposition(currentNumberGroup.getNumberGroupAppendage());
					
					if (numberGroups.size() > 0) {
						if (nextNumberGroup().isNotZero() && (nextNumberGroup().isGreaterThan(99) || numberGroups.size() > 1)) {
							appendToComposition(", ");
						}
					}
				}
			}
		}
		return composition.toString();
	}

	private NumberGroup nextNumberGroup() {
		return numberGroups.next();
	}
	
	private void appendToComposition(String text) {
		composition.append(text);
	}

}
