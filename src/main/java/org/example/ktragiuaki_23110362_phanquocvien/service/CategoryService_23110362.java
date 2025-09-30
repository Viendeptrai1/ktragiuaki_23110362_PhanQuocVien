package org.example.ktragiuaki_23110362_phanquocvien.service;

import org.example.ktragiuaki_23110362_phanquocvien.entity.Category_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService_23110362 {
    private final CategoryRepository categoryRepository;

    public CategoryService_23110362(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category_23110362> findPage(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Category_23110362> findById(Integer id) { return categoryRepository.findById(id); }
    public Category_23110362 save(Category_23110362 c) { return categoryRepository.save(c); }
    public void deleteById(Integer id) { categoryRepository.deleteById(id); }
}


