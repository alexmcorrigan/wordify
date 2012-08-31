package com.mcorrigal.wordify;

public class Translator {

	private TranslationComposer translationComposer;
	
	public Translator(TranslationComposer translationComposer) {
		this.translationComposer = translationComposer;
	}
	
	public String translateNumberToWords(int number) {
		return translationComposer.composeTranslationFor(number);
	}
	
}
