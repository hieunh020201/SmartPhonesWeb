package com.hieunh.SmartPhonesWeb.repositories;

import com.hieunh.SmartPhonesWeb.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
    public Long countById(String id);
}
