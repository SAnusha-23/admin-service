package com.cg.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ims.config.JwtGeneratorInterface;
import com.cg.ims.dto.AdminDTO;
import com.cg.ims.dto.CategoryDto;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.AdminException;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.exception.ProductException;
import com.cg.ims.exception.UserNotFoundException;
import com.cg.ims.service.IAdminService;
import com.cg.ims.service.IAdminServiceImpl;



import io.swagger.annotations.Api;
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
	
	
	//private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@ApiOperation("viewing all admins")
	@GetMapping("/getalladmins")
	public List<AdminDTO> viewAllAdmins()
	{
		return service.getAllAdmins();
	}
	@Autowired
	  public AdminController(IAdminService userService, JwtGeneratorInterface jwtGenerator){
	    this.adminservice=userService;
	    this.jwtGenerator=jwtGenerator;
	  }
	@ApiOperation("register admin")
	@PostMapping("/register")
	  public ResponseEntity<?> postUser(@RequestBody AdminDTO user){
	  try{
	     adminservice.saveUser(user);
	     return new ResponseEntity<>(user, HttpStatus.CREATED);
	   } catch (Exception e){
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
	        //jsonResponse.put("message", null);
	        jsonResponse.put("token", token);
	        jsonResponse.put("role", userData.getrole()); // Add the role to the JSON response
	        
	        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	        //return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);

	        
	    } catch (AdminException e) {
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("message", e.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	    }
	}
	
	
	@PostMapping("/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody AdminDTO user) throws UserNotFoundException{
		adminservice.changePassword(user);
		return new ResponseEntity<String>("Password Updated", HttpStatus.OK);
	}

//	@PostMapping("/login")
//	  public ResponseEntity<?> loginUser(@RequestBody AdminDTO user) throws UserNotFoundException {
//	    try {
//	      if(user.getUserName() == null || user.getPassword() == null) {
//	      throw new AdminException("UserName or Password is Empty");
//	    }
//	      AdminDTO userData = adminservice.getUserByNameAndPassword(user.getUserName(), user.getPassword());
//		    if(userData == null){
//		       throw new UserNotFoundException("UserName or Password is Invalid");
//		    }
//		      return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
//		      
//		    } catch (AdminException e) {
//		       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//		    }
//		  }
//	@ResponseStatus(HttpStatus.ACCEPTED)
//
//    @GetMapping("/login")
//
//    public UserResponse login(@RequestParam String user, @RequestParam String password, HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//
//        System.out.println(session);
//
//        UserDetails userDb = uService.login(new UserDetails(user, password));
//
//        System.out.println(userDb.toString());
//
//        // session.setAttribute("userid", userDb.getUserId());
//
//        session.setAttribute("username", userDb.getUserName());
//
//        session.setAttribute("role", userDb.getUserRole());
//
//        session.setAttribute("password", userDb.getPassword());
//
//        String token = jwtTokenUtil.generateToken(String.valueOf(userDb.getUserId()), userDb.getUserName(),
//
//                userDb.getUserRole());
//
//        System.out.println(token.toString());
//
//        UserResponse response = new UserResponse();
//
//        response.setToken(token);
//
//        response.setUserId(userDb.getUserId());
//
//        response.setUserName(userDb.getUserName());
//
//        response.setUserRole(userDb.getUserRole());
//
//        ResponseEntity<UserResponse> resEntity = new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		
//		@ApiOperation("Adding a new product")
//		@PostMapping("/addproduct1")
//		public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) throws ProductException {
//			ProductDTO addedproduct = service.addProduct(product);
//	        return new ResponseEntity<>(addedproduct, HttpStatus.CREATED);
//	    }
//		@ApiOperation("view all products")
//		@GetMapping("/getallproducts1")
//	    public ResponseEntity<List<ProductDTO>> viewAllProduct() throws ProductException {
//	        List<ProductDTO> allProducts = service.getAllProducts();
//	        return new ResponseEntity<>(allProducts, HttpStatus.OK);
//	    }
//		
//		
//		 @ApiOperation("add a new category")
//		@PostMapping("/addcategoryy")
//		    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto cat) throws CategoryException {
//		        CategoryDto addedCategory = categoryService.addCategory(cat);
//		        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
//		    }
//		 @ApiOperation("view all category")
//		 @GetMapping("/viewallcategoryy")
//		    public ResponseEntity<List<CategoryDto>> viewAllCategory() throws CategoryException {
//		        List<CategoryDto> allCategories = categoryService.viewAllCategory();
//		        return new ResponseEntity<>(allCategories, HttpStatus.OK);
//		    }
//		
		
	}



