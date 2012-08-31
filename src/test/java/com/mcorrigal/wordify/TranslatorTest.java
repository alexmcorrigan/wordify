package com.mcorrigal.wordify;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TranslatorTest {

	@Test
	public void translatorInterface() throws Exception {
		Translator translator = new Translator(new TranslationComposer());
		assertEquals("one hundred and twenty three million, four hundred and fifty six thousand, seven hundred and eighty nine", translator.translateNumberToWords(123456789));
		assertEquals("two billion, one hundred and fourty seven million, four hundred and eighty three thousand, six hundred and fourty seven", translator.translateNumberToWords(2147483647));
		
	}
	
}
