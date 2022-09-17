package com.hieunh.SmartPhonesWeb.specification;

import com.hieunh.SmartPhonesWeb.entities.Cart;
import com.hieunh.SmartPhonesWeb.entities.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class CartSpecification {

    public static Specification<Cart> hasIdUser(Integer id) {
        return (root, query, criteriaBuilder) -> {
            Join<Cart, User> userCart = root.join("user");
            return criteriaBuilder.equal(userCart.get("user").get("id"), id);
        };
    }
}
