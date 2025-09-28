package com.SPM.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
	
	@NotBlank(message = "Name is required")
    private String name;
	@NotBlank(message = "Description is required")
    private String description;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stockQuantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public ProductDTO(@NotBlank(message = "Name is required") String name, String description,
			@Min(value = 0, message = "Stock cannot be negative") int stockQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.stockQuantity = stockQuantity;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", description=" + description + ", stockQuantity=" + stockQuantity + "]";
	}

    

}
