package com.hieunh.SmartPhonesWeb.repositories;

import com.hieunh.SmartPhonesWeb.entities.Cart;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {
    public static Specification<Cart> hasIdUser(Integer id) {
        return null;
    }

    Specification<Cart> spec = hasIdUser(1);
    public List<Cart> findAll();
}
