package com.liferay.product;

import com.liferay.enumerations.Type;

public class Product {

	private String itemName;
	private int quantity;
	private double price;
	private double salesTax;
	private boolean sTxApplicatble;
	private double importDuty;
	private boolean importDutyApplicable;
	private double finalTotal;
	private Type type;

	public Product(Float price, int quantity, String name) {
		this.price = price;
		this.quantity = quantity;
		this.itemName = name;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean issTxApplicatble() {
		return sTxApplicatble;
	}

	public void setsTxApplicatble(boolean sTxApplicatble) {
		this.sTxApplicatble = sTxApplicatble;
	}

	public boolean isImportDutyApplicable() {
		return importDutyApplicable;
	}

	public void setImportDutyApplicable(boolean importDutyApplicable) {
		this.importDutyApplicable = importDutyApplicable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalesTax() {
		salesTax = getType().getSalesTax() * quantity * price;
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public double getImportDuty() {
		if (itemName.indexOf("import") != -1)
			importDuty = getType().getImportDuty() * quantity * price;
		else
			importDuty = 0.0;
		return importDuty;
	}

	public void setImportDuty(double importDuty) {
		this.importDuty = importDuty;
	}

	public double getFinalTotal() {
		finalTotal = (quantity * price) + getSalesTax() + getImportDuty();
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public Type getType() {
		if (itemName == null)
			return type.OTHERS;
		else {
			boolean itB = false;
			for (Type it : Type.values()) {
				String commaExemptions = it.getExemptionGoods();
				if (commaExemptions == null
						|| commaExemptions.equalsIgnoreCase(""))
					continue;
				String[] exemptionsArr = commaExemptions.split(",");
				for (String s : exemptionsArr)
					if (itemName.indexOf(s) != -1) {
						return it;
					}
			}
		}
		return type.OTHERS;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public static Product create(Float price, int quantity, String name) {
		return new Product(price, quantity, name);
	}

}
