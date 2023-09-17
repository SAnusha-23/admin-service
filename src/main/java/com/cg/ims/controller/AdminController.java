package com.cg.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ims.config.JwtGeneratorInterface;
import com.cg.ims.dto.AdminDTO;
import com.cg.ims.exception.AdminException;
import com.cg.ims.exception.UserNotFoundException;
import com.cg.ims.service.IAdminService;
import com.cg.ims.service.IAdminServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ims")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private IAdminServiceImpl service;

	@Autowired
	private IAdminService adminservice;

	private JwtGeneratorInterface jwtGenerator;

	@ApiOperation("viewing all admins")
	@GetMapping("/getalladmins")
	public List<AdminDTO> viewAllAdmins() {
		return service.getAllAdmins();
	}

	@Autowired
	public AdminController(IAdminService userService, JwtGeneratorInterface jwtGenerator) {
		this.adminservice = userService;
		this.jwtGenerator = jwtGenerator;
	}

	@ApiOperation("register admin")
	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody AdminDTO user) {
		try {
			adminservice.saveUser(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@ApiOperation("login admin")

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser(@RequestBody AdminDTO user) throws UserNotFoundException {
		try {
			if (user.getUserName() == null || user.getPassword() == null) {
				throw new AdminException("UserName or Password is Empty");
			}

			AdminDTO userData = adminservice.getUserByNameAndPassword(user.getUserName(), user.getPassword());

			if (userData == null) {
				throw new UserNotFoundException("UserName or Password is Invalid");
			}

			Map<String, String> token = jwtGenerator.generateToken(user);

			Map<String, Object> jsonResponse = new HashMap<>();
			jsonResponse.put("token", token);
			jsonResponse.put("role", userData.getrole()); // Add the role to the JSON response

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

		} catch (AdminException e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody AdminDTO user) throws UserNotFoundException {
		adminservice.changePassword(user);
		return new ResponseEntity<String>("Password Updated", HttpStatus.OK);
	}
}
