package com.SPM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.SPM.Entity.Product;
import com.SPM.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
    public Product create(Product p) {
        return productRepository.save(p);
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
	
	public Product update(Long id, Product p) {
        Product existing = get(id);
        if (p.getStockQuantity() < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        existing.setName(p.getName());
        existing.setDescription(p.getDescription());
        existing.setStockQuantity(p.getStockQuantity());
        return productRepository.save(existing);
    }

	public void delete(Long id) {
	    Product product = productRepository.findById(id)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	    productRepository.delete(product);
	}

    public Product increaseStock(Long id, int amount) {
        Product p = get(id);
        p.setStockQuantity(p.getStockQuantity() + amount);
        return productRepository.save(p);
    }

    public Product decreaseStock(Long id, int amount) {
        Product p = get(id);
        if (p.getStockQuantity() < amount) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        p.setStockQuantity(p.getStockQuantity() - amount);
        return productRepository.save(p);
    }
    
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        productRepository.delete(product);
    }


}
