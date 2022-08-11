package com.hieunh.SmartPhonesWeb.services;

import com.hieunh.SmartPhonesWeb.entities.Category;
import com.hieunh.SmartPhonesWeb.exception.NotFoundException;
import com.hieunh.SmartPhonesWeb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category>listAll() {
        return (List<Category>) repository.findAll();
    }

    public void save(Category category) {
        repository.save(category);
    }

    public void delete(Integer id) throws NotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new NotFoundException("Could not find any users with ID " + id);
        }
        repository.deleteById(id);
    }

}
