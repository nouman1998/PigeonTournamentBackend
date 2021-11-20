package com.piegon.Controller;

import com.piegon.DTO.CategoryDTO;
import com.piegon.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
}
