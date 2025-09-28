package com.SPM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SPM.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
