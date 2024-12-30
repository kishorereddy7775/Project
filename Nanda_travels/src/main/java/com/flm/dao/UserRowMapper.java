package com.flm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.flm.model.User;

@Component
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setUser_id(rs.getInt("user_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setMobileNumber(rs.getString("mobile_number"));
		user.setGender(rs.getString("gender"));
		user.setEmail(rs.getString("email_id"));
		user.setPassword(rs.getString("password"));
		user.setFailedCount(rs.getInt("failed_count"));
		user.setActiveStatus(rs.getString("account_status"));
		return user;
	}

}
