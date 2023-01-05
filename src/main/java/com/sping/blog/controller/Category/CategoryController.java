package com.sping.blog.controller.Category;

import com.sping.blog.dto.Category.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/create")
    public String createForm() {
        return "/category/createPage";
    }

    @PostMapping("/create")
    public String createCategory(CategoryDto categoryDto) {
        return "redirect:/category";
    }
}
