package orion.Dayoff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import orion.Dayoff.entity.User;
import orion.Dayoff.repository.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}
	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	public User getOneUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}


}
