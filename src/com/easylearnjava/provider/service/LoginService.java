package com.easylearnjava.provider.service;

import com.easylearnjava.provider.dao.LoginDao;
import com.easylearnjava.provider.dto.User;
import com.easylearnjava.provider.exception.DaoException;
import com.easylearnjava.provider.exception.ServiceException;

public class LoginService {

	/**
	 * This class just acts like a delegate
	 */
	public User getUserDetails(String userName) {

		LoginDao loginDao = new LoginDao();
		
		try {
			User user = loginDao.getUserDetails(userName);
			return user;
		} catch (Exception ex) {
			if (!(ex instanceof DaoException)) {
				ex.printStackTrace();
			}
			throw new ServiceException();
		}
	}
}
