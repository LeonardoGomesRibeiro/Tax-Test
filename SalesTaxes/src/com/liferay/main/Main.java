package com.liferay.main;

import java.io.BufferedReader;

import com.liferay.file.util.AbstractFileReader;
import com.liferay.file.util.FileUtil;
import com.liferay.file.util.ProductReader;
import com.liferay.product.Product;
import com.liferay.product.Receipt;

public class Main {

	public static void main(String[] args) {

		BufferedReader bufferedReader = new BufferedReader(FileUtil.getFileReader(args[0]));
		
		AbstractFileReader<Product> reader = new ProductReader(bufferedReader);
		reader.readFile();
		
		Receipt.create(reader.getLines()).print(System.out);
	}
}
