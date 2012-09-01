package com.mcorrigal.wordify;

import static com.mcorrigal.wordify.Dictionary.integerTranslationExists;
import static com.mcorrigal.wordify.Dictionary.lookUpAdditionalAppedageForFactor;
import static com.mcorrigal.wordify.Dictionary.lookUpAppedageForFactor;
import static com.mcorrigal.wordify.Dictionary.lookUpIntegerTranslation;
import static com.mcorrigal.wordify.Dictionary.lookUpNumberGroupAppendage;
import static com.mcorrigal.wordify.Dictionary.lookUpSpecialPrependTranslation;
import static com.mcorrigal.wordify.Dictionary.specialPrependTranslationExists;

public class NumberGroupTranslator {
	
	public NumberGroup translate(int numberGroup, int totalNumberGroups, int indexOfThisNumberGroup) {
		String numberGroupTranslation = getTranslation(numberGroup);
		String numberGroupAppendage = getNumberGroupAppendage(totalNumberGroups, indexOfThisNumberGroup);
		return new NumberGroup(numberGroup, numberGroupTranslation, numberGroupAppendage);
	}
	
	private String getNumberGroupAppendage(int totalNumberGroups, int indexOfThisNumberGroup) {
		return lookUpNumberGroupAppendage(totalNumberGroups - indexOfThisNumberGroup);
	}

	private String getTranslation(int numberGroup) {
		if (integerTranslationExists(numberGroup)) {
			return lookUpIntegerTranslation(numberGroup);
		} else {
			return createTranslationForNumberGreaterThanNine(numberGroup);
		}
	}
	
	private String createTranslationForNumberGreaterThanNine(int number) {
		boolean isTeen = number > 9 && number < 20; 
		boolean lessThanHundred = number < 100;
		int mostSignificantPart;
		int factor;
		
		if (isTeen) {
			factor = 0;
			mostSignificantPart = getMostSignificantPart(number, 1);
		} else {
			factor = (number > 19 && lessThanHundred) ? 10 : 100;
			mostSignificantPart = getMostSignificantPart(number, 0);
		}
		
		String appendage = lookUpAppedageForFactor(factor);
		String additionalAppendage = lookUpAdditionalAppedageForFactor(factor);
		int leastSignificantPart = factor == 0 ? 0 : getLeastSignificantPart(number, mostSignificantPart, factor);
		return buildFullTranslation(lessThanHundred, mostSignificantPart, leastSignificantPart, appendage, additionalAppendage, factor);
	}
	
	private String buildFullTranslation(
			boolean lessThanHundred,
			int mostSignificantPart,
			int leastSignificantPart, 
			String appendage,
			String additionalAppendage, 
			int factor) {
		StringBuilder translationBulder = new StringBuilder();
		translationBulder.append(buildMostSignificantPartTranslation(mostSignificantPart, lessThanHundred, appendage));
		if (leastSignificantPart != 0) translationBulder.append(additionalAppendage + getTranslation(leastSignificantPart));
		return translationBulder.toString();
	}

	private String buildMostSignificantPartTranslation(int mostSignificantPart, boolean isLessThanHundred, String appedage) {
		if (isLessThanHundred) {
			if (specialPrependTranslationExists(mostSignificantPart)) {
				return lookUpSpecialPrependTranslation(mostSignificantPart) + appedage;
			} else {
				return lookUpIntegerTranslation(mostSignificantPart) + appedage;
			}
		} else {
			return lookUpIntegerTranslation(mostSignificantPart) + appedage;
		}
	}
	
	private int getMostSignificantPart(int number, int indexOfMostSignificantPart) {
		return integerAtIndex(number, indexOfMostSignificantPart);
	}
	
	private int getLeastSignificantPart(int number, int mostSignificantPart, int factor) {
		return number - (mostSignificantPart * factor);
	}

	private int integerAtIndex(int number, int index) {
		char charactor = String.valueOf(number).toCharArray()[index];
		return Character.digit(charactor, 10);
	}

}
