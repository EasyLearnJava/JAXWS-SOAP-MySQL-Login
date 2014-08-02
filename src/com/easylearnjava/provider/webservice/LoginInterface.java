package com.easylearnjava.provider.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface LoginInterface {

	@WebMethod
	public UserWrapper getUserDetails(String userName) ;
	
}
