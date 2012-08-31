package com.mcorrigal.wordify;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TranslationComposerTest {

	private TranslationComposer translationComposer = new TranslationComposer();
	
	@Test
	public void fullCompositions() {
		assertCompositionFor(1, "one");
		assertCompositionFor(12, "twelve");
		assertCompositionFor(123, "one hundred and twenty three");
		assertCompositionFor(1234, "one thousand, two hundred and thirty four");
		assertCompositionFor(12345, "twelve thousand, three hundred and fourty five");
		assertCompositionFor(123456, "one hundred and twenty three thousand, four hundred and fifty six");
		assertCompositionFor(1234567, "one million, two hundred and thirty four thousand, five hundred and sixty seven");
		assertCompositionFor(12345678, "twelve million, three hundred and fourty five thousand, six hundred and seventy eight");
		assertCompositionFor(123456789, "one hundred and twenty three million, four hundred and fifty six thousand, seven hundred and eighty nine");
	}
	
	@Test
	public void mostSignificantPartCompositions() {
		assertCompositionFor(1, "one");
		assertCompositionFor(1000, "one thousand");
		assertCompositionFor(10000, "ten thousand");
		assertCompositionFor(100000, "one hundred thousand");
		assertCompositionFor(1000000, "one million");
		assertCompositionFor(10000000, "ten million");
		assertCompositionFor(100000000, "one hundred million");
		assertCompositionFor(1000000000, "one billion");
	}
	
	@Test
	public void partCompositions() {
		assertCompositionFor(1001, "one thousand and one");
		assertCompositionFor(1000001, "one million and one");
		assertCompositionFor(1001001, "one million, one thousand and one");
		assertCompositionFor(1000000001, "one billion and one");
		assertCompositionFor(1001000001, "one billion, one million and one");
		assertCompositionFor(1001001001, "one billion, one million, one thousand and one");
		assertCompositionFor(1022033044, "one billion, twenty two million, thirty three thousand and fourty four");
	}
	
	private void assertCompositionFor(int number, String expectedComposition) {
		assertEquals(expectedComposition, translationComposer.composeTranslationFor(number));
	}
	
}
