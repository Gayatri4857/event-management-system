package org.dnyanyog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

	@Autowired
	UsersRepository userRepo;// ask spring to give object of 'Query class for users' i.e. UserRepository

	@Autowired
	UserResponse userResponse;

	@Autowired
	List<String> userNames;

	public UserResponse addUpdateUser(UserRequest request) {

		Users usersTable = new Users();
		usersTable.setRole(request.getRole());
		usersTable.setEmail(request.getEmail());
		usersTable.setPassword(request.getPassword());
		usersTable.setUsername(request.getUsername());
		usersTable.setMobile_no(request.getMobile_no());

		// long currentBeforeTimeMillis = System.currentTimeMillis();
		
		usersTable = userRepo.save(usersTable);

		// long currentAfterTimeMillis = System.currentTimeMillis();
		
		userResponse.getUserData().setRole(usersTable.getRole());
		userResponse.getUserData().setEmail(usersTable.getEmail());
		userResponse.getUserData().setPassword(usersTable.getPassword());
		userResponse.getUserData().setUsername(usersTable.getUsername());
		userResponse.getUserData().setMobile_no(usersTable.getMobile_no());
		userResponse.setMessage("User Added Successfuly");
		userResponse.setStatus("Success");
		
		return userResponse;
		
	}
	

}
