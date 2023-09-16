//package com.cg.ims.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.ims.dto.CustomerDTO;
//import com.cg.ims.exception.CustomerException;
//import com.cg.ims.service.ICustomerServiceImpl;
//
//@RestController
//@RequestMapping("/inventory")
//public class CustomerController {
//	@Autowired
//	private ICustomerServiceImpl customerService;
//	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
//	 
//
//	@PostMapping("/addcustomer")
//	 public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO cust) throws CustomerException {
//	    	CustomerDTO addCustomer=customerService.addCustomer(cust);
//	    	return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
//	    }
//	 
//	 @PutMapping("/updatecustomer")
//	 public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO cust)throws CustomerException {
//		 CustomerDTO updateCustomer=customerService.updateCustomer(cust);
//	    	return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
//	    }
//	 
//	 
//	 @GetMapping("/getallcustomer")
//	 public ResponseEntity<List<CustomerDTO>> viewAllCustomer()throws CustomerException{
//		 List<CustomerDTO> allCustomers = customerService.viewAllCustomer();
//	        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
//	 }
//
//	 @GetMapping("/getcustomerbyid/{id}")
//	 public ResponseEntity<CustomerDTO> viewcustomer(@PathVariable("id") int id)throws CustomerException{
//		 CustomerDTO customer = customerService.viewCustomer(id);
//	        return new ResponseEntity<>(customer, HttpStatus.OK);
//		 
//     }
//	 
//	 @DeleteMapping("/deletecustomer/{id}")
//	 public ResponseEntity<CustomerDTO> removeCustomer(@PathVariable("id") int id) throws CustomerException{
//		  CustomerDTO removedCustomer = customerService.removeCustomer(id);
//	        return new ResponseEntity<>(removedCustomer, HttpStatus.OK);
//		 
//		}
//	 
//		}
//
//
//
//
//
