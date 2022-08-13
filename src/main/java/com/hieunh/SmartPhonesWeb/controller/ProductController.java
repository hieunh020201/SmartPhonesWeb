package com.hieunh.SmartPhonesWeb.controller;

import com.hieunh.SmartPhonesWeb.entities.Category;
import com.hieunh.SmartPhonesWeb.entities.Product;
import com.hieunh.SmartPhonesWeb.exception.NotFoundException;
import com.hieunh.SmartPhonesWeb.services.CategoryService;
import com.hieunh.SmartPhonesWeb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public String showProduct(Model model) {
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);

        return "product";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes ra) {
        productService.save(product);
        ra.addFlashAttribute("message", "The product has been save successfully");
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Product product = productService.findById(id);
            model.addAttribute("product", product);
            List<Category> categories = categoryService.listAll();
            model.addAttribute("categories", categories);
            model.addAttribute("pageTitle", "Edit Product (ID: " + id + ")");
            return "product_form";
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/product";
        }
    }

    @GetMapping("/product/new")
    public String showNewProductForm(Model model) {
        List<Category> categories = categoryService.listAll();
        System.out.println("Xem nào" + categories);
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Add New Product");
        return "product_form";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            productService.delete(id);
            ra.addFlashAttribute("message", "The product ID " + id + " has been deleted");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/product";
    }
}
