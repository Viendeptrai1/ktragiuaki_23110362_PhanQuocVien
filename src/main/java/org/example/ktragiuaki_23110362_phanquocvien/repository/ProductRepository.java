package org.example.ktragiuaki_23110362_phanquocvien.repository;

import org.example.ktragiuaki_23110362_phanquocvien.entity.Product_23110362;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product_23110362, Integer> {
    @Query("select p from Product_23110362 p join fetch p.seller s left join fetch p.category c order by s.sellerId, p.productId")
    List<Product_23110362> findAllWithSellerAndCategory();
}


