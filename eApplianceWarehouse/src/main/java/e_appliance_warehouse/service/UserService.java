package e_appliance_warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import e_appliance_warehouse.model.User;
import e_appliance_warehouse.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepo;
	
	// ADD NEW USER
	public void addUser(User user) {
		user.setEmail(user.getEmail().toLowerCase());
		userRepo.save(user);
	}
	
	// GET ALL USERS
	public List<User> getAllUsers() {
		return userRepo.getAllUsers();
	}
	
	// GET INACTIVE USERS
	public List<User> getInactiveUsers() {
		return userRepo.getInactiveUsers();
	}
	
	// GET ACTIVE USERS
	public List<User> getActiveUsers() {
		return userRepo.getActiveUsers();
	}	
	
	// GET USER BY userID
	public User getUserById(int userId) {
		return userRepo.getUserById(userId);
	}
	
	// GET USER BY firstNAME (OR CONTAINS PART OF THE NAME)
	public List<User> getUserByName(String firstName) {
		return userRepo.getUserByName(firstName);
	}
	
	// GET USER BY USERNAME - ACTIVE ONLY
	public User getUserByUsername(String username) {
		return userRepo.getUserByUsername(username);
	}
	
	// USER LOGIN
	public Boolean userLogin(String username, String password) {
		boolean resp = false;
		User user = getUserByUsername(username);
		
		if(user != null) {
			if(user.getEmail().equalsIgnoreCase(username) & user.getPassword().equals(password)) {
				resp = true;
			}
		}
		
		return resp;
	}
	
	// CHANGE PASSWORD
	public void changePassword(String password, String email) {
		userRepo.changePassword(password, email);
	}
	
	// SAVE LOGIN TIMESTAMP & USER COMMENT
	public void saveUserLoginAndComment(String loginTimestamp, String userComment, String email) {
		userRepo.saveUserLoginAndComment(loginTimestamp, userComment, email);
	}
	
	// UPDATE USER
	public void updateUser(User user) {
		user.setEmail(user.getEmail().toLowerCase());
		userRepo.save(user);
	}
	
	// DELETE USER By userID
	public void deleteUser(int userId) {
		userRepo.deleteUser(userId);
	}

}
