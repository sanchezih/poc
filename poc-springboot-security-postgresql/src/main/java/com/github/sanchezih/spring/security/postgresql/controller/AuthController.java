package com.github.sanchezih.spring.security.postgresql.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.spring.security.postgresql.models.ERole;
import com.github.sanchezih.spring.security.postgresql.models.Role;
import com.github.sanchezih.spring.security.postgresql.models.User;
import com.github.sanchezih.spring.security.postgresql.payload.request.LoginRequest;
import com.github.sanchezih.spring.security.postgresql.payload.request.SignupRequest;
import com.github.sanchezih.spring.security.postgresql.payload.response.JwtResponse;
import com.github.sanchezih.spring.security.postgresql.payload.response.MessageResponse;
import com.github.sanchezih.spring.security.postgresql.repository.RoleRepository;
import com.github.sanchezih.spring.security.postgresql.repository.UserRepository;
import com.github.sanchezih.spring.security.postgresql.security.jwt.JwtUtils;
import com.github.sanchezih.spring.security.postgresql.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final static String ROLE_ADMIN = "admin";
	private final static String ROLE_MODERATOR = "mod";
	
	private final static String USER_REGISTERED_SUCC = "User registered successfully!";

	private final static String ERROR_ROLE_NOT_FOUND = "Error: Role is not found.";
	private final static String ERROR_USERNAME_TAKEN = "Error: Username is already taken!";
	private final static String ERROR_EMAIL_INUSE = "Error: Email is already in use!";

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse(ERROR_USERNAME_TAKEN));
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse(ERROR_EMAIL_INUSE));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException(ERROR_ROLE_NOT_FOUND));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case ROLE_ADMIN:
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException(ERROR_ROLE_NOT_FOUND));
					roles.add(adminRole);
					break;
				case ROLE_MODERATOR:
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException(ERROR_ROLE_NOT_FOUND));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException(ERROR_ROLE_NOT_FOUND));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse(USER_REGISTERED_SUCC));
	}
}
