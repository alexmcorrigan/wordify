package com.mcorrigal.wordify;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumberGroupCollectionTest {
	
	private NumberGroupCollection numberGroupCollection;

	@Before
	public void setup() {
		numberGroupCollection = new NumberGroupCollection();
	}
	
	@Test
	public void newNumberGroupCollection() {
		numberGroupCollection.add(new NumberGroup(50, "fifty", ""));
		assertEquals(numberGroupCollection.size(), 1);
	}
	
	@Test
	public void getFromNumberGroupCollection() {
		numberGroupCollection.add(new NumberGroup(50, "fifty", ""));
		assertEquals(50, numberGroupCollection.get(0).getNumberGroupValue());
	}
	
}
