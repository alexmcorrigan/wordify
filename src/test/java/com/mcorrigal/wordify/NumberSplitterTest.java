package com.mcorrigal.wordify;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class NumberSplitterTest {

		private NumberSplitter numberSplitter = new NumberSplitter();

		@Test
		public void one() {
			assertNumberSplitIntoGroupsOf(1, makeArrayOf(1));
		}
		
		@Test
		public void twelve() {
			assertNumberSplitIntoGroupsOf(12, makeArrayOf(12));
		}
		
		@Test
		public void oneHundredTwentyThree() {
			assertNumberSplitIntoGroupsOf(123, makeArrayOf(123));
		}
		
		@Test
		public void onethousandTwoHundredThirtyFour() {
			assertNumberSplitIntoGroupsOf(1234, makeArrayOf(1, 234));
		}
		
		@Test
		public void twelvethousandThreeHundredFortyFive() {
			assertNumberSplitIntoGroupsOf(12345, makeArrayOf(12, 345));
		}
		
		@Test
		public void oneHundredTwentyThreethousandFourHundredFiftySix() {
			assertNumberSplitIntoGroupsOf(123456, makeArrayOf(123, 456));
		}
		
		@Test
		public void oneMillionTwoHundredThirtyFourthousandFiveHundredSixtySeven() {
			assertNumberSplitIntoGroupsOf(1234567, makeArrayOf(1, 234, 567));
		}
		
		@Test
		public void listOfGroupsReturnedInOrderOfGreatesValueFirst() {
			List<Integer> numberGroup = numberSplitter.splitUp(1234567);
			assertTrue(numberGroup.get(0) == 1);
			assertTrue(numberGroup.get(0) == 1);
			assertTrue(numberGroup.get(1) == 234);
			assertTrue(numberGroup.get(2) == 567);
		}
	
		private void assertNumberSplitIntoGroupsOf(int number, Integer[] expectedItems) {
			assertThat(numberSplitter.splitUp(number), hasItems(expectedItems));
		}
		
		private Integer[] makeArrayOf(Integer... values) {
			return values;
		}
	
}
