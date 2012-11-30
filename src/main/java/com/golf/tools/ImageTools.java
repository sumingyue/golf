package com.golf.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageTools {

	private static String getStoreImageName(String fileName) {
		int index = fileName.lastIndexOf('.');

		if (index > 0) {
			return System.currentTimeMillis() + fileName.substring(index);
		}
		return System.currentTimeMillis() + ".png";

	}

	public static String getImageStorePath(String fileName, int type) {
		String typeName = "/news/";
		if (type == 2) {
			typeName = "/adwords/";
		} else {
			typeName = "/other/";
		}
		String day = new SimpleDateFormat("yyyyMMdd/").format(new Date());
		String path = typeName + day + System.currentTimeMillis() + getStoreImageName(fileName);
		return path;
	}
}
