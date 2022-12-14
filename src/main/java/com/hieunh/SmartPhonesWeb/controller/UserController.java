package com.hieunh.SmartPhonesWeb.controller;

import com.hieunh.SmartPhonesWeb.entities.Cart;
import com.hieunh.SmartPhonesWeb.entities.Category;
import com.hieunh.SmartPhonesWeb.entities.Product;
import com.hieunh.SmartPhonesWeb.entities.User;
import com.hieunh.SmartPhonesWeb.services.CustomUserDetailService;
import com.hieunh.SmartPhonesWeb.services.ProductService;
import com.hieunh.SmartPhonesWeb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CustomUserDetailService service;

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/login")
    public String viewAdminLoginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "admin/admin_login";
        }
        return "redirect:/admin/home";
    }

    @GetMapping("/user/login")
    public String viewUserLoginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "user/user_login";
        }
        return "redirect:/user/home";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(){
        return "admin/admin_home";
    }

    @GetMapping("/user/home")
    public String viewUserHomePage(){
        return "user/user_home";
    }


    @PostMapping("/register/save")
    public String saveAccountUser(User user, RedirectAttributes ra) {
        service.registerUser(user);
        ra.addFlashAttribute("message", "The user has been save successfully");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String saveAccountUser(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }

    @GetMapping("/user/product")
    public String viewUserProductPage(Model model) {
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);

        return "user/product_page";
    }

    @GetMapping("/user/cart")
    public String viewUserCartPage(Model model) {
        Specification<Cart> specification =
    }
}
