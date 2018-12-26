package com.sample.service;

import com.sample.model.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
