package com.hieunh.SmartPhonesWeb.services;

import com.hieunh.SmartPhonesWeb.entities.Cart;
import com.hieunh.SmartPhonesWeb.exception.NotFoundException;
import com.hieunh.SmartPhonesWeb.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.hieunh.SmartPhonesWeb.specification.CartSpecification.hasIdUser;

@Service
public class CartService {
    @Autowired
    CartRepository repository;

    public Cart findCartById(Integer id) throws NotFoundException{
        Specification<Cart> specification = repository.hasIdUser(id);
        if (specification == null) {
            return result.get();
        }

        throw new NotFoundException("Count not find any cart with ID " + id);
    }

    Specification<Cart> specification = hasIdUser(1);

    public List<Cart> findAll(specification) {
        return null;
    }
}
