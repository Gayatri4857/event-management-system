package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.FeedBackRequest;
import org.dnyanyog.dto.FeedBackResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.FeedBack;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.FeedBackRepository;
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
	
	@Autowired
	FeedBackRepository feedbackRepo;

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
	
	public FeedBackResponse addFeedback(FeedBackRequest request) {
		FeedBackResponse feedbackResponse=new FeedBackResponse();
				FeedBack feedbackTable = new FeedBack();
				feedbackTable.setUsername(request.getUsername());
				feedbackTable.setEmail(request.getEmail());
				feedbackTable.setFeedBack(request.getFeedBack());
				feedbackTable.setFeedBackemoji(request.getFeedBackemoji());
				// long currentBeforeTimeMillis = System.currentTimeMillis();
				
				feedbackTable = feedbackRepo.save(feedbackTable);

				// long currentAfterTimeMillis = System.currentTimeMillis();
				
				feedbackResponse.setUsername(request.getUsername());
				feedbackResponse.setFeedBack(request.getFeedBack());
				feedbackResponse.setEmail(request.getEmail());
				feedbackResponse.setFeedBackemoji(request.getFeedBackemoji());
				
				return feedbackResponse;
				
			}
	

	public UserResponse getSingleUser(String nameToSearch) {

		List<Users> receivedData = userRepo.findByUsername(nameToSearch);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("fail");
			userResponse.setMessage("User Not Found");
		} else {
			Users user = receivedData.get(0);
			userResponse.setMessage("Success");
			userResponse.setStatus("User Found");

			UserData userData = userResponse.getUserData();
			
			userData.setRole(user.getRole());
			userData.setEmail(user.getEmail());
			userData.setPassword(user.getPassword());
			userData.setUsername(user.getUsername());
			userData.setMobile_no(user.getMobile_no());
		}
		return userResponse;
	}
}
