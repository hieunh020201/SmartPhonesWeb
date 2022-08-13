package com.hieunh.SmartPhonesWeb.controller;

import com.hieunh.SmartPhonesWeb.entities.Category;
import com.hieunh.SmartPhonesWeb.exception.NotFoundException;
import com.hieunh.SmartPhonesWeb.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public String showCategory(Model model) {
        List<Category> categories = service.listAll();
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categories);
        return "category";
    }

    @PostMapping("/category/save")
    public String saveCategory(Category category, RedirectAttributes ra) {
        service.save(category);
        ra.addFlashAttribute("message", "The category has been save successfully");
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable String id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The category ID " + id + " has been deleted");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/category";
    }
}
