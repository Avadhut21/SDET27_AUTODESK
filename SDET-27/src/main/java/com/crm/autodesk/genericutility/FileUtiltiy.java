package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Avadhut
 *
 */

public class FileUtiltiy {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws IOException 
	 * @throws Throwable 
	 */
	public String getPropertykeyValue(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./data/commonData.property");
	Properties pobj = new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value; 
		
	}
	}



	
