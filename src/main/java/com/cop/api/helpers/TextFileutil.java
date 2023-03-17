package com.cop.api.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.cop.api.utils.FrameworkConstants;

public class TextFileutil {

	
	public static void updatetoken(String Value) throws IOException {
	FileOutputStream out = new FileOutputStream(FrameworkConstants.TOKEN_FILE_PATH);
	FileInputStream in = new FileInputStream(FrameworkConstants.TOKEN_FILE_PATH);
	 try {
		
      Properties props = new Properties();
      props.load(in);
      in.close();
      props.setProperty("token", Value);
      props.store(out, null);
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 finally {
      out.close();
	 }
	}
}
