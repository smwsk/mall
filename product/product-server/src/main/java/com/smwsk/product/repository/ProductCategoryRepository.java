package com.smwsk.product.repository;

import com.smwsk.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
