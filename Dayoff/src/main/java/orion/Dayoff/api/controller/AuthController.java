package orion.Dayoff.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orion.Dayoff.entity.User;
import orion.Dayoff.request.UserRequest;
import orion.Dayoff.response.AuthResponse;
import orion.Dayoff.security.JwtTokenProvider;
import orion.Dayoff.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private JwtTokenProvider jwtTokenProvider;
	private AuthenticationManager authenticationManager;
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public String login(@RequestBody UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		 
		User user = userService.getOneUserByUserName(loginRequest.getUserName());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setAccessToken("Bearer " + jwtToken);
		authResponse.setUserId(user.getId());
		
		return "Bearer " + jwtToken;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserRequest registerRequest){
		if(userService.getOneUserByUserName(registerRequest.getUserName()) != null)
			return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);
		User user = new User();
		user.setUserName(registerRequest.getUserName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.saveOneUser(user);
		return new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
	}	
}
