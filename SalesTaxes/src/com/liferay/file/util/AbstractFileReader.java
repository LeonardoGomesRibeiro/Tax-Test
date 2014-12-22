package com.liferay.file.util;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractFileReader<T> {

	protected List<T> lines = new ArrayList<T>();
	public List<T> getLines() {
		return lines;
	}
	public abstract void readFile();

	

}
