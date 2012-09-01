package com.mcorrigal.wordify;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberGroupTest {

	@Test
	public void numberGroupIsNotZero() {
		NumberGroup numberGroup = new NumberGroup(1, "one", "");
		assertTrue(numberGroup.isNotZero());
	}
	
	@Test
	public void numberGroupIsLessThan() {
		NumberGroup numberGroup = new NumberGroup(50, "fifty", "");
		assertTrue(numberGroup.isLessThan(75));
		assertFalse(numberGroup.isLessThan(25));
	}
	
	@Test
	public void numberGroupIsGreaterThan() {
		NumberGroup numberGroup = new NumberGroup(50, "fifty", "");
		assertTrue(numberGroup.isGreaterThan(25));
		assertFalse(numberGroup.isGreaterThan(75));
	}
	
}
