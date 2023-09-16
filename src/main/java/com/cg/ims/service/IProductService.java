package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.ProductException;

public interface IProductService {
	public ProductDTO addProduct(ProductDTO product) throws ProductException;
	public ProductDTO updateProduct(ProductDTO product) throws ProductException;
	public ProductDTO deleteProduct(Integer id) throws ProductException;
	public ProductDTO getProductById(Integer id) throws ProductException;
	public List<ProductDTO> getAllProducts();

}
