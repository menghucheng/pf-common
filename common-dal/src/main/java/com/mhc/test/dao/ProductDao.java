package com.mhc.test.dao;

import com.mhc.test.model.Product;
import com.mhc.test.model.ProductExample;
import org.springframework.stereotype.Service;

/**
 * ProductDao继承基类
 */
@Service("productDao")
public interface ProductDao extends MyBatisBaseDao<Product, Integer, ProductExample> {
}