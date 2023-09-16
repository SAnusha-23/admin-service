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
//import com.cg.ims.dto.CategoryDto;
//import com.cg.ims.exception.CategoryException;
//import com.cg.ims.service.ICategoryServiceImpl;
//
//@RestController
//@RequestMapping("/category")
//public class CategoryController {
//	@Autowired
//	ICategoryServiceImpl categoryService;
//
//	 private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
//	
//    @PostMapping("/addcategory")
//    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto cat) throws CategoryException {
//        CategoryDto addedCategory = categoryService.addCategory(cat);
//        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updatecategory")
//    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto cat) throws CategoryException {
//        CategoryDto updatedCategory = categoryService.updateCategory(cat);
//        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/removecategory/{id}")
//    public ResponseEntity<CategoryDto> removeCategory(@PathVariable("id") Integer id) throws CategoryException {
//        CategoryDto removedCategory = categoryService.removeCategory(id);
//        return new ResponseEntity<>(removedCategory, HttpStatus.OK);
//    }
//
//    @GetMapping("/viewallcategory")
//    public ResponseEntity<List<CategoryDto>> viewAllCategory() throws CategoryException {
//        List<CategoryDto> allCategories = categoryService.viewAllCategory();
//        return new ResponseEntity<>(allCategories, HttpStatus.OK);
//    }
//
//    @GetMapping("/viewcategory/{id}")
//    public ResponseEntity<CategoryDto> viewcategory(@PathVariable("id") Integer id) throws CategoryException {
//        CategoryDto category = categoryService.viewCategory(id);
//        return new ResponseEntity<>(category, HttpStatus.OK);
//    }
//  
//	@GetMapping("/eurekha")
//	public String name() {
//		return "eurekha";
//	}
//}
//
//
//
