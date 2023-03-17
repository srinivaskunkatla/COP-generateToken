package com.cop.api.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromTxtFile {

	
	
	public static String readtxtFile(String filePath) throws IOException {
		
		 String content = null;
		    File file = new File(filePath); 
		    FileReader reader = null;
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        content = new String(chars);
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader != null){
		            reader.close();
		        }
		    }
		    return content;
	}

	    }
