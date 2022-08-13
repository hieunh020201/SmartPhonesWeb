package com.hieunh.SmartPhonesWeb.services;

import com.hieunh.SmartPhonesWeb.entities.Product;
import com.hieunh.SmartPhonesWeb.exception.NotFoundException;
import com.hieunh.SmartPhonesWeb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService{
    @Autowired
    private ProductRepository repository;

    public List<Product> listAll() {
        return (List<Product>) repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void delete(Integer id) throws NotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new NotFoundException("Could not find any products with ID " + id);
        }
        repository.deleteById(id);
    }

    public Product findById(Integer id) throws NotFoundException {
        Optional<Product> result = repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new NotFoundException("Count not find any products with ID " + id);
    }
}
