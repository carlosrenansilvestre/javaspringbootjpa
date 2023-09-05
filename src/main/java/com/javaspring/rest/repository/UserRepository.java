package com.javaspring.rest.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaspring.rest.model.User;

public class UserRepository {
	public List<User> findAll() {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/local_database", "root", "");
			Statement stmt = con.createStatement();
			String sql = "select * from users";
			ResultSet rset = stmt.executeQuery(sql);
			
			List<User> users = new ArrayList<>();
			
			while(rset.next()) {
				User user = new User();
	            Integer id = rset.getInt("id");
	            String name = rset.getString("name");
	            user.setId(id);
	            user.setName(name);
	            users.add(user);
			}
			
			return users;
		} catch (SQLException e) {
			return null;
		}
	
	}
}
