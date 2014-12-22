package com.liferay.file.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class FileUtil {
	
	public static FileReader getFileReader(String fileName) {
		URL url = (URL)new FileUtil().getClass().getClassLoader().getResource(fileName);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(url.getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileReader;
	}

}
