package com.srivastava.apps;

import java.io.FileInputStream;

public class FS {
	public String bringData() throws Exception {
		FileInputStream fs =
				new FileInputStream("/Users/amit/Documents/Framework-SeptBatch/javaconfigdemo/src/main/java/com/srivastava/apps/Producer.java");
	int singleByte = fs.read();
	StringBuilder sb = new StringBuilder();
	while(singleByte!=-1) {
		sb.append((char)singleByte);
		singleByte = fs.read();
	}
	fs.close();
	 return  sb.toString();
	}
}
