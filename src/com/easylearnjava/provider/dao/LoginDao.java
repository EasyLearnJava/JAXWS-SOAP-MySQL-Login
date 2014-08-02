package com.easylearnjava.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.easylearnjava.provider.dto.User;
import com.easylearnjava.provider.exception.DaoException;
import com.easylearnjava.provider.util.DBConnection;

public class LoginDao {
	
	/**
	 * Method which fetches user record from the data base
	 * @param userName
	 * @return
	 */
	public User getUserDetails(String userName){

		Connection conn;
		PreparedStatement stmt;
		User user = null;
		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getDBConnection(); //get the data base connection object
			String sql = "SELECT * FROM  USER where user_name = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				user = new User();
				user.setId(res.getInt("USER_ID"));
				user.setUserName(res.getString("USER_NAME"));
				user.setUserPassword(res.getString("USER_PASSWORD"));
			}
			dbConn.closeConnection(); //close the database connection
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DaoException();
		}
		return user;
	}
	
}
