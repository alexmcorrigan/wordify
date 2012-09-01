package com.mcorrigal.wordify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberGroupCollection implements Iterator<NumberGroup> {

	private List<NumberGroup> numberGroups = new ArrayList<NumberGroup>();
	
	public void add(NumberGroup numberGroup) {
		numberGroups.add(numberGroup);
	}
	
	public int size() {
		return numberGroups.size();
	}

	public NumberGroup get(int numberGroupIndex) {
		return numberGroups.get(numberGroupIndex);
	}

	@Override
	public boolean hasNext() {
		return numberGroups.size() > 0;
	}

	@Override
	public NumberGroup next() {
		NumberGroup nextNumberGroup = numberGroups.get(0);
		//numberGroups.remove(0);
		return nextNumberGroup;
	}

	@Override
	public void remove() {
		numberGroups.remove(0);
	}

}
