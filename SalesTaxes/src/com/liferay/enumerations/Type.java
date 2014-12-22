package com.liferay.enumerations;

public enum Type {

	BOOKS(0.0, 0.0, "book"),
	FOOD(0.0, 0.0, "food,drinks,beverages,chocolate"), 
	MEDICAL(0.0, 0.0, "tablets,tonics,oinments"), 
	OTHERS(0.1, 0.05, "");

	private double salesTax;
	private double importDuty;
	private String exemptionGoods;

	private Type(double salesTax, double importDuty, String exemptionGoods) {
		this.salesTax = salesTax;
		this.importDuty = importDuty;
		this.exemptionGoods = exemptionGoods;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public double getImportDuty() {
		return importDuty;
	}

	public String getExemptionGoods() {
		return exemptionGoods;
	}

}
