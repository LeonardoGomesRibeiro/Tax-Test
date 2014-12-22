package com.liferay.product;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Product> products;
	
	public Receipt() {
		products = new ArrayList<Product>();
	}
	
	public Receipt(List<Product> products) {
		this.products = products;
	}

	public static Receipt create(List<Product> products) {
		return new Receipt(products);
	}
	
	public static Receipt create() {
		return new Receipt();
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void startPrinting(PrintStream out) {
		
	}
	
	public void print(PrintStream out) {
		double totalSalesTax = 0.0;
		double totalAmount = 0.0;
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMinimumFractionDigits(2);
		df.setMinimumIntegerDigits(1);
		
		out.println("======== OUTPUT =======");
		
		int i = 0;
		for (Product product : products) {
			String total = df.format(product.getFinalTotal());
			out.println(product.getQuantity() + " " + product.getItemName() + ": " + total);
			totalSalesTax += product.getSalesTax();
			totalAmount += product.getFinalTotal();
		}
		
		out.println("Total Sales Tax: " + df.format(totalSalesTax));
		out.println("Total Amount: " + df.format(totalAmount));

	}
}
