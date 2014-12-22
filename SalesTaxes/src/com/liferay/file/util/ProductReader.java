package com.liferay.file.util;

import java.io.BufferedReader;

import com.liferay.product.Product;

public class ProductReader extends AbstractFileReader<Product> {

	private BufferedReader bufferedReader;

	public ProductReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public void readFile() {
		try {
			String productLine = null;
			
			while ((productLine = bufferedReader.readLine()) != null) {
				if (productLine != null) {
					String[] detail = productLine.split(" at ");
					System.out.println(detail[0] + " " + detail[1]);

					Product product = Product.create(Float.valueOf(detail[1]), 
									Integer.parseInt("" + detail[0].charAt(0)),
									detail[0].substring(2));
					
					lines.add(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
