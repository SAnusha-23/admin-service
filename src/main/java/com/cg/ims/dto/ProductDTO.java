package com.cg.ims.dto;

public class ProductDTO {

	int productId;

	String productName;

	double price;

	String specification;

	int quantity;

	CategoryDto category;

	public ProductDTO() {
		super();
	}

	public ProductDTO(int productId, String productName, double price, String color, String dimension,
			String specification, String manufacturer, int quantity, CategoryDto category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.specification = specification;
		this.quantity = quantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", specification=" + specification + " quantity=" + quantity + ", category=" + category + "]";
	}

}
