package com.liferay.enumerations;

public enum Tax {
	
	SALESTAX(0.1), 
	IMPORTDUTY(0.05);

	private double percentage;

	private Tax(double percentage) {
		this.percentage = percentage;
	}

	public double getPercentage() {
		return percentage;
	}

}
