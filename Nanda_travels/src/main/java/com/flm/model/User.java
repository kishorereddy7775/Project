package com.flm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	int user_id;
	String firstName;
	String lastName;
	String mobileNumber;
	String gender;
	String email;
	String password;
	int failedCount;
	String activeStatus;
	
}
