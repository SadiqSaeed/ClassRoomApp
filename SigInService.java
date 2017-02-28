package com.classroom.app.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.classroom.app.database.DBConnection;
import com.classroom.app.model.SignIn;
import java.sql.Statement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SigInService implements SigInInterface {

	private Connection con = null;
	private String Message = "";

	@Override
	public String authenticateUser(String userName, String password) {
		DBConnection connection = new DBConnection();
		SignIn signIn = new SignIn(userName, password);
		try {
			con = connection.openConnection();
			Statement st = con.createStatement();

			String query = "Select userName, password, status from SigIn where userName = '" + signIn.getUserName()
					+ "' And password = '" + signIn.getPassword() + "'";

			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				signIn.setStatus(rs.getInt("status"));
				if (signIn.getStatus() == 0) {
					Message = "You registeration is not complete yet please check your mail";
					// System.out.println(Message);
				} else if (signIn.getStatus() == 1) {
					Message = "SuccessFull LogIn";
					// System.out.println(Message);
				}
			} else {
				Message = "Invalid email or password";
				// System.out.println(Message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection(con);
		}

		return Message;
	}

}
