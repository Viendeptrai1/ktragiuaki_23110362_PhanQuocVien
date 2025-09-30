package org.example.ktragiuaki_23110362_phanquocvien.entity;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category_23110362 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Integer categoryId;

    @Column(name = "categoryname", nullable = false, length = 200)
    private String categoryName;

    @Column(name = "images", length = 500)
    private String images;

    @Column(name = "status")
    private Integer status;

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}


