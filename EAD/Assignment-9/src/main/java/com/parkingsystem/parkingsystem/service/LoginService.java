package com.parkingsystem.service;

import com.parkingsystem.dao.LoginDAO;
import com.parkingsystem.model.pojo.LoginPOJO;

public class LoginService {

	private static LoginService loginFacade = null;

	public static LoginService getInstance() {

		if (loginFacade == null) {
			loginFacade = new LoginService();
		}
		return loginFacade;
	}

	public boolean login(LoginPOJO loginPOJO) throws Exception {

		LoginDAO loginDAO = LoginDAO.getInstance();

		try {
			return loginDAO.login(loginPOJO);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
