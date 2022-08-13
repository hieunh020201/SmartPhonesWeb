package com.hieunh.SmartPhonesWeb.repositories;

import com.hieunh.SmartPhonesWeb.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Long countById(Integer id);
}
