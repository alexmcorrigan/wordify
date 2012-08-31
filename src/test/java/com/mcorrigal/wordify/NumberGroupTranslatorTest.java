package com.mcorrigal.wordify;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberGroupTranslatorTest {

	private NumberGroupTranslator translator = new NumberGroupTranslator();
	
	@Test
	public void integersBelowTen() {
		assertTranslationFor(0, "zero");
		assertTranslationFor(1, "one");
		assertTranslationFor(2, "two");
		assertTranslationFor(3, "three");
		assertTranslationFor(4, "four");
		assertTranslationFor(5, "five");
		assertTranslationFor(6, "six");
		assertTranslationFor(7, "seven");
		assertTranslationFor(8, "eight");
		assertTranslationFor(9, "nine");
	}
	
	@Test
	public void integersTenToNineteen() {
		assertTranslationFor(10, "ten");
		assertTranslationFor(11, "eleven");
		assertTranslationFor(12, "twelve");
		assertTranslationFor(13, "thirteen");
		assertTranslationFor(14, "fourteen");
		assertTranslationFor(15, "fifteen");
		assertTranslationFor(16, "sixteen");
		assertTranslationFor(17, "seventeen");
		assertTranslationFor(18, "eighteen");
		assertTranslationFor(19, "nineteen");
	}
	
	@Test
	public void multipleOfTenIntegersTwentyToNinety() {
		assertTranslationFor(20, "twenty");
		assertTranslationFor(30, "thirty");
		assertTranslationFor(40, "fourty");
		assertTranslationFor(50, "fifty");
		assertTranslationFor(60, "sixty");
		assertTranslationFor(70, "seventy");
		assertTranslationFor(80, "eighty");
		assertTranslationFor(90, "ninety");
	}
	
	@Test
	public void integersBetweenMultipleOfTenIntegers() {
		assertTranslationFor(21, "twenty one");
		assertTranslationFor(32, "thirty two");
		assertTranslationFor(43, "fourty three");
		assertTranslationFor(54, "fifty four");
		assertTranslationFor(65, "sixty five");
		assertTranslationFor(76, "seventy six");
		assertTranslationFor(87, "eighty seven");
		assertTranslationFor(98, "ninety eight");
	}
	
	@Test
	public void hundreds() {
		assertTranslationFor(100, "one hundred");
		assertTranslationFor(200, "two hundred");
		assertTranslationFor(101, "one hundred and one");
		assertTranslationFor(123, "one hundred and twenty three");
		assertTranslationFor(456, "four hundred and fifty six");
		assertTranslationFor(789, "seven hundred and eighty nine");
	}
	
	private void assertTranslationFor(int number, String expectedTranslation) {
		assertEquals(expectedTranslation, translationFor(number));
	}

	private String translationFor(int number) {
		return translator.translate(number);
	}
	
}
