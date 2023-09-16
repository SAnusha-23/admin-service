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
//import com.cg.ims.dto.ProductDTO;
//import com.cg.ims.exception.ProductException;
//import com.cg.ims.service.IProductServiceImpl;
//
//@RestController
//@RequestMapping("/ims")
//public class ProductController {
//	@Autowired
//	private IProductServiceImpl service;
//	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
//	
//	@PostMapping("/addproduct")
//	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) throws ProductException {
//		ProductDTO addedproduct = service.addProduct(product);
//        return new ResponseEntity<>(addedproduct, HttpStatus.CREATED);
//    }
//	 
//	@PutMapping("/updateproduct")
//    public ResponseEntity<ProductDTO> updateproduct(@RequestBody ProductDTO product) throws ProductException {
//		ProductDTO updatedProduct = service.updateProduct(product);
//        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
//    }
//	 
//	
//	@GetMapping("/getproduct/{id}")
//    public ResponseEntity<ProductDTO> viewproduct(@PathVariable("id") Integer id) throws ProductException {
//		ProductDTO product = service.getProductById(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//	
//	@DeleteMapping("/deleteproduct/{id}")
//	public ResponseEntity<ProductDTO> removeProduct(@PathVariable("id") Integer id) throws ProductException
//	{
//		 ProductDTO removedProduct = service.deleteProduct(id);
//	     return new ResponseEntity<>(removedProduct, HttpStatus.OK);
//	}
//	
//	@GetMapping("/getallproducts")
//    public ResponseEntity<List<ProductDTO>> viewAllProduct() throws ProductException {
//        List<ProductDTO> allProducts = service.getAllProducts();
//        return new ResponseEntity<>(allProducts, HttpStatus.OK);
//    }
//	
//
//}
