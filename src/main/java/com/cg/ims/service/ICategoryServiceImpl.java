//package com.cg.ims.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.ims.dto.CategoryDto;
//import com.cg.ims.exception.CategoryException;
//import com.cg.ims.repository.ICategoryRepository;
//
//@Service
//public class ICategoryServiceImpl implements ICategoryService {
////	@Autowired
////	private ICategoryRepository categoryRepository;
////	
//    private static final Logger logger = LoggerFactory.getLogger(ICategoryServiceImpl.class);
//
//
//	@Override
//	public CategoryDto addCategory(CategoryDto cat) throws CategoryException{
//		
//		logger.info("Adding new category: {}", cat);
//		if(categoryRepository.existsById(cat.getCatId()))
//			throw new CategoryException("Category already exists");
//		else {
//			logger.info("Category added successfully: {}", cat);
//			return categoryRepository.save(cat);
//		
//		}
//	}
//
//	@Override
//	public CategoryDto updateCategory(CategoryDto cat) throws CategoryException {
//		logger.info("Updating category: {}", cat);
//	    try {
//	        CategoryDto updatedCategory = categoryRepository.save(cat);
//	        if (updatedCategory == null) {
//	            throw new CategoryException("Failed to update category.");
//	        }
//	        logger.info("Category updated successfully: {}", cat);
//	        return updatedCategory;
//	    } catch (Exception e) {
//	        throw new CategoryException("Error while updating category: " + e.getMessage());
//	    }
//	}
//
//	@Override
//	public CategoryDto removeCategory(Integer catId) throws CategoryException {
//		logger.info("Removing category with ID: {}", catId);
//		if(categoryRepository.existsById(catId)) {
//		CategoryDto cat = categoryRepository.findById(catId).get();
//		categoryRepository.delete(cat);
//		logger.info("Category removed successfully with ID: {}", catId);
//		return cat;
//		}
//		else
//			throw new CategoryException("Category Id not found");
//		
//	}
//	
//	@Override
//	public CategoryDto viewCategory(Integer catId) {
//		logger.info("Viewing category with ID: {}", catId);
//		Optional<CategoryDto> findById = categoryRepository.findById(catId);
//		logger.info("Category viewed successfully with ID: {}", catId);
//
//		return findById.orElseThrow(() -> new CategoryException("There are no category having id:" + catId));
//	}
//
//
//	@Override
//	public List<CategoryDto> viewAllCategory() throws CategoryException{
//		logger.info("Viewing all categories");
//		if(categoryRepository.count() > 0) {
//		List<CategoryDto> cts = categoryRepository.findAll();
//		
//		logger.info("Categories viewed successfully");
//		return cts;
//		}
//		else throw new CategoryException("Category Records not found");
//	}
//
//
//	
//
//
//	
//
//}
