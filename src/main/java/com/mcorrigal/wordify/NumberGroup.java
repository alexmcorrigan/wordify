package com.mcorrigal.wordify;

public class NumberGroup {

	private int numberGroupValue;
	private String numberGroupTranslation;
	private String numberGroupAppendage;
	
	public NumberGroup(
			int numberGroupValue,
			String numberGroupTranslation,
			String numberGroupAppendage) {
		this.numberGroupValue = numberGroupValue;
		this.numberGroupTranslation = numberGroupTranslation;
		this.numberGroupAppendage = numberGroupAppendage;
	}

	public int getNumberGroupValue() {
		return numberGroupValue;
	}
	
	public String getNumberGroupTranslation() {
		return numberGroupTranslation;
	}

	public String getNumberGroupAppendage() {
		return numberGroupAppendage;
	}

	public boolean isNotZero() {
		return numberGroupValue != 0;
	}

	public boolean isLessThan(int comparitor) {
		return numberGroupValue < comparitor;
	}

	public boolean isGreaterThan(int comparitor) {
		return numberGroupValue > comparitor;
	}

}
