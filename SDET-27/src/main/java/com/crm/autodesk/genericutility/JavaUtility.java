package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * @author avadhut
 */
public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @param  
	 * @return int data
	 */
	public int  getRandomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	/**
	 *  used to get system date & time in IST format
	 *  @return
	 */
	public String  getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * used to get system date in YYYY-MM-DD
	 * @return
	 */
	public String getSystemDateWithFormat () {
		Date date = new Date();
		String dateAndTime = date.toString();

		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormate = YYYY +"-"+MM+"-"+DD;


		return finalFormate;

	}
	
}
