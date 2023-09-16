//package com.cg.ims.service;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.ims.dto.CustomerDTO;
//import com.cg.ims.exception.CustomerException;
//import com.cg.ims.repository.ICustomerRepository;
//
//@Service
//public class ICustomerServiceImpl implements ICustomerService {
//	@Autowired
//	  private ICustomerRepository customerRepository;
//	 private static final Logger logger = LoggerFactory.getLogger(ICustomerServiceImpl.class);
//	    
//	    public CustomerDTO addCustomer(CustomerDTO cust) throws CustomerException{
//	    	logger.info("Adding new Customer: {}",cust);
//	    	if(customerRepository.existsById(cust.getCustomerId())) {
//	    		 throw new CustomerException("Id already exist");
//	    	}
//	    	else {
//	    	customerRepository.save(cust);
//	    	}
//	    	logger.info("Customer added successfully: {}", cust);
//	    	return cust;
//	    }
//	    public CustomerDTO updateCustomer(CustomerDTO cust)throws CustomerException {
//	    	logger.info("Updating new Customer: {}",cust);
//	    	if(customerRepository.existsById(cust.getCustomerId())) {
//	    		customerRepository.save(cust); 
//	    	}
//	    	else {
//	    		throw new CustomerException("Id does not exist");
//	    	}
//	    	logger.info("updated customer successfully: {}",cust);
//	    	return cust;
//	    }
//public CustomerDTO removeCustomer(int id) throws CustomerException
//{
//	   logger.info("Removing new Customer: {}",id);
//	   if(customerRepository.existsById(id)) 
//	   {
//		   CustomerDTO cust=customerRepository.findById(id).get();
//		   if(customerRepository.existsById(id))
//		   {
//			   customerRepository.deleteById(id);
//		   }
//		   logger.info("removed customer successfully: {}",cust);
//		   return cust;
//	   }
//	   else 
//	   {
//		   throw new CustomerException("Id not found");
//	   }
//	   
//}
////public List<CustomerDTO> viewAllCustomer(){
//// return customerRepository.findAll();
////}
//
//public CustomerDTO viewCustomer(int id) throws CustomerException{
//	logger.info("viewing Customer: {}",id);
//	  if(customerRepository.existsById(id)) {
//	  return customerRepository.findById(id).get();
//	  }
//	  else {
//		  logger.info("customer viewed successfully: {}",id);
//		  throw new CustomerException("Id not found");
//	  }
//}
//
//
//@Override
//public List<CustomerDTO> viewAllCustomer()throws CustomerException {
//	
//	logger.info("viewing all customers");
//  List<CustomerDTO> crts = customerRepository.findAll();
//  logger.info("viewed customers successfully");
//
//  return crts;
//}
//
//
//
//
//}
