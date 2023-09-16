package com.cg.ims.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ims.dto.AdminDTO;
import com.cg.ims.dto.CategoryDto;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.AdminException;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.exception.ProductException;
import com.cg.ims.exception.UserNotFoundException;
import com.cg.ims.repository.IAdminRepository;
//import com.cg.ims.repository.ICategoryRepository;
//import com.cg.ims.repository.IProductRepository;
//import com.user.module.entity.Users;
//import com.user.module.exception.UserException;

@Service
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository adminRepository;
//	@Autowired
//	private ICategoryRepository categoryRepository;
//	@Autowired
//	private IProductRepository productRepository;
	
	public static final String ADMIN = "ADMIN";
	
	
	/*@Override
    public AdminDTO registerAdmin(String username,String password) {
    	AdminDTO user = new AdminDTO();
    	user.setUserName(username);
    	user.setPassword(password);
    	
    	//user.setRole(ADMIN);
    	System.out.println("Registration success");
       return adminRepository.save(user);    
    }*/
	public List<AdminDTO> getAllAdmins() 
	{
		List<AdminDTO> list=adminRepository.findAll();
		return list;
	}
	
	
	/*public  AdminDTO signIn(AdminDTO login1) throws AdminException {
	  	int userid = login1.getId() ;
		String userName = login1.getUserName();
		String password = login1.getPassword();

		Optional<AdminDTO> login = adminRepository.findById(userid);

		if (login.isEmpty() || !login.get().getPassword().equals(password)) {

			throw new AdminException("Bad Credentials");
		}
		return  login.get();
	}*/
	
	//private static final Logger logger = LoggerFactory.getLogger(ICategoryServiceImpl.class);
	
	@Override
	  public void saveUser(AdminDTO user) {
	    adminRepository.save(user);
	  }
	  @Override
	  public AdminDTO getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
	    AdminDTO user = adminRepository.findByUserNameAndPassword(name, password);
	    if(user == null){
	       throw new UserNotFoundException("Invalid id and password");
	    }
	    return user;
	  }
	
	public AdminDTO validateUser(int id,String pwd)throws AdminException
	{
		AdminDTO credentials= adminRepository.validateUser(id,pwd);
		if(credentials==null) {
			throw new AdminException("Login credentials mismatched");
		}
		else {
			return credentials;
			
		}
		
	}
//	@Override
//	public CategoryDto addCategory(CategoryDto category) throws CategoryException
//	{
//		logger.info("Adding new Category: {}",category);
//		if(categoryRepository.existsById(category.getCatId()))
//		{
//			throw new CategoryException("Category Id already exist");
//		}
//		else
//		{
//			categoryRepository.save(category);
//			logger.info(" New Category added: {}",category);
//			return category;
//		}
//	}

//	@Override
//	public List<CategoryDto> getAllCategories() throws CategoryException {
//		logger.info("viewing all categories");
//		if(categoryRepository.count()>0) {
//			List<CategoryDto> cts =categoryRepository.findAll();
//			logger.info("categories viewed successfully");
//			return cts;
//		}
//		else throw new CategoryException("Category Records not found");
//		
//		
//	}

//	@Override
//	public ProductDTO addProduct(ProductDTO product) throws ProductException {
//		if(productRepository.existsById(product.getProductId()))
//		{
//			throw new ProductException("Product Id already exist");
//		}
//		else
//		{
//			productRepository.save(product);
//			return product;
//		}
//	}

//	@Override
//	public List<ProductDTO> getAllProducts() {
//		List<ProductDTO> list=productRepository.findAll();
//		return list;
//	}
	
	

   public AdminDTO viewUser(int userId) {
	   return adminRepository.findById(userId).get();
   }
   
   
@Override
public AdminDTO changePassword(AdminDTO user) throws UserNotFoundException {
	String userName = user.getUserName();
	Optional<AdminDTO> repUsers=adminRepository.findUserByUserName(userName);
	AdminDTO u = repUsers.orElseThrow(()-> new UserNotFoundException("User Not Found"));
	
	u.setPassword(user.getPassword());
	adminRepository.save(u);
	return u;
}
	
}


	


