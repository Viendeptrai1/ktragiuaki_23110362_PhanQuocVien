package org.example.ktragiuaki_23110362_phanquocvien.controller;

import org.example.ktragiuaki_23110362_phanquocvien.entity.Category_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.service.CategoryService_23110362;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController_23110362 {
    private final CategoryService_23110362 categoryService;

    public AdminCategoryController_23110362(CategoryService_23110362 categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Category_23110362> p = categoryService.findPage(page, 5);
        model.addAttribute("page", p);
        return "admin/category/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("c", new Category_23110362());
        return "admin/category/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("c") Category_23110362 c) {
        categoryService.save(c);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Category_23110362 c = categoryService.findById(id).orElse(null);
        if (c == null) return "redirect:/admin/categories";
        model.addAttribute("c", c);
        return "admin/category/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }
}


