package org.example.ktragiuaki_23110362_phanquocvien.service;

import org.example.ktragiuaki_23110362_phanquocvien.entity.Product_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService_23110362 {
    private final ProductRepository productRepository;

    public ProductService_23110362(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Integer, List<Product_23110362>> getProductsGroupedBySeller() {
        List<Product_23110362> products = productRepository.findAllWithSellerAndCategory();
        Map<Integer, List<Product_23110362>> map = new LinkedHashMap<>();
        for (Product_23110362 p : products) {
            Integer sellerId = p.getSeller() != null ? p.getSeller().getSellerId() : null;
            if (sellerId == null) {
                sellerId = -1;
            }
            map.computeIfAbsent(sellerId, k -> new ArrayList<>()).add(p);
        }
        return map;
    }

    public Optional<Product_23110362> findById(Integer id) {
        return productRepository.findById(id);
    }
}


