package com.easylearnjava.provider.util;

public class Helper {
	
	/**
	 * Method for validating the input values
	 * 
	 * @param userName
	 * @return
	 */
	public boolean isValidData(String userName) {
		if ((null != userName) && (userName != "") && (userName.length() >= 5)) {
			return true;
		}
		return false;
	}


}
