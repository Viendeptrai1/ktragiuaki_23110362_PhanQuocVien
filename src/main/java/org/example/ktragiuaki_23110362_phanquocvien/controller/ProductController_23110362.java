package org.example.ktragiuaki_23110362_phanquocvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.example.ktragiuaki_23110362_phanquocvien.service.ProductService_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.entity.Product_23110362;
import java.util.*;

@Controller
public class ProductController_23110362 {
    private final ProductService_23110362 productService;

    public ProductController_23110362(ProductService_23110362 productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        Map<Integer, List<Product_23110362>> grouped = productService.getProductsGroupedBySeller();
        model.addAttribute("grouped", grouped);
        return "products/index";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Integer id, Model model) {
        Optional<Product_23110362> opt = productService.findById(id);
        if (!opt.isPresent()) {
            return "redirect:/products";
        }
        model.addAttribute("p", opt.get());
        return "products/detail";
    }
}
