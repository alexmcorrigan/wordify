package com.mcorrigal.wordify;

import static com.mcorrigal.wordify.Dictionary.AND;
import static com.mcorrigal.wordify.Dictionary.COMMA;
import static com.mcorrigal.wordify.Dictionary.*;

import java.util.List;

public class TranslationComposer {

	private NumberSplitter numberSplitter = new NumberSplitter();
	private NumberGroupTranslator numberGroupTranslator = new NumberGroupTranslator();
	private StringBuilder composition;
	private NumberGroupCollection numberGroups;
	
	public String composeTranslationFor(int number) {
		composition = new StringBuilder();
		numberGroups = new NumberGroupCollection();
		
		if (number < 0) {
			composition.append(MINUS);
			number = Math.abs(number);
		}
		
		List<Integer> numberGroupValues = numberSplitter.splitUp(number);
		for (int i = 0; i < numberGroupValues.size(); i++) {
			numberGroups.add(numberGroupTranslator.translate(numberGroupValues.get(i), numberGroupValues.size(), i));
		}
		while (numberGroups.hasNext()) {
			NumberGroup currentNumberGroup = numberGroups.next();
			numberGroups.remove();
			if (currentNumberGroup.isNotZero()) appendTranslationForNumberGroup(number, currentNumberGroup);
		}
		return composition.toString();
	}

	private void appendTranslationForNumberGroup(int number, NumberGroup currentNumberGroup) {
		if (shouldPrependAnd(number, currentNumberGroup)) {
			appendNumberGroupTranslationWithAndPrependage(currentNumberGroup); 
		} else {
			appendNumberGroupTranslationWithAppendage(currentNumberGroup);
			if (shouldAppendComma()) appendToComposition(COMMA);
		}
	}

	private boolean shouldPrependAnd(int number, NumberGroup currentNumberGroup) {
		return number > 100 && numberGroups.size() == 0 && currentNumberGroup.isLessThan(100);
	}

	private boolean shouldAppendComma() {
		return numberGroups.size() > 0 && nextNumberGroup().isNotZero() && (nextNumberGroup().isGreaterThan(99) || numberGroups.size() > 1);
	}

	private void appendNumberGroupTranslationWithAppendage(NumberGroup currentNumberGroup) {
		composition.append(currentNumberGroup.getNumberGroupTranslation() + currentNumberGroup.getNumberGroupAppendage());
	}

	private void appendNumberGroupTranslationWithAndPrependage(NumberGroup currentNumberGroup) {
		composition.append(AND + currentNumberGroup.getNumberGroupTranslation());
	}

	private NumberGroup nextNumberGroup() {
		return numberGroups.next();
	}
	
	private void appendToComposition(String text) {
		composition.append(text);
	}

}
