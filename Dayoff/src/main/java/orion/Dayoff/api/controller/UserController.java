package orion.Dayoff.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orion.Dayoff.entity.User;
import orion.Dayoff.response.UserResponse;
import orion.Dayoff.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers().stream().map(u -> new UserResponse(u)).toList();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public UserResponse getOneUser(@PathVariable Long userId) {
		User user = userService.getOneUserById(userId);
		
		return new UserResponse(user);
	}
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId,newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	

}
