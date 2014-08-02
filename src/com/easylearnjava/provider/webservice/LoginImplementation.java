package com.easylearnjava.provider.webservice;

import javax.jws.WebService;

import com.easylearnjava.provider.dto.User;
import com.easylearnjava.provider.exception.InvalidDataException;
import com.easylearnjava.provider.exception.ServiceException;
import com.easylearnjava.provider.service.LoginService;
import com.easylearnjava.provider.util.Constants;
import com.easylearnjava.provider.util.Helper;

@WebService(endpointInterface = "com.easylearnjava.provider.webservice.LoginInterface")
public class LoginImplementation implements LoginInterface {

	@Override
	public UserWrapper getUserDetails(String userName) {

		UserWrapper userWrapper = new UserWrapper();
		try {

			// inputdata validation
			Helper helper = new Helper();
			boolean isDataValid = helper.isValidData(userName);
			if (!isDataValid) {
				//userWrapper.setStatusId(Constants.FAILURE_STATUS_MESSAGE);
				throw new InvalidDataException("username is required");
			}

			LoginService loginService = new LoginService();
			User userObject = loginService.getUserDetails(userName);
			
			if(null != userObject){
				userWrapper.setUser(userObject);
				userWrapper.setStatusId(Constants.SUCCESS_STATUS_MESSAGE);
			}else{
				userWrapper.setStatusId(Constants.FAILURE_STATUS_MESSAGE);
			}

			return userWrapper;

		} catch (Exception ex) {
			if (!(ex instanceof ServiceException)) {
				ex.printStackTrace();
			}
			userWrapper.setStatusId(Constants.EXCEPTION_STATUS_MESSAGE);
			//return userWrapper;
			throw new NullPointerException("Soap Fault...");
		}
	}
}
