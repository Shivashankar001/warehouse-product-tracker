package com.SPM.Mapper;

import com.SPM.DTO.ProductDTO;
import com.SPM.Entity.Product;

public class ProductMapper {
	
	public static Product toEntity(ProductDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setStockQuantity(dto.getStockQuantity());
        return p;
    }

    public static ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setStockQuantity(p.getStockQuantity());
        return dto;
    }


}
