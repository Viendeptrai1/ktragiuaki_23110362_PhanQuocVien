package org.example.ktragiuaki_23110362_phanquocvien.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product_23110362 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "productname", nullable = false, length = 200)
    private String productName;

    @Column(name = "productcode")
    private Long productCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid")
    private Category_23110362 category;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "images", length = 500)
    private String images;

    @Column(name = "wishlist")
    private Integer wishlist;

    @Column(name = "status")
    private Integer status;

    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellerid")
    private Seller_23110362 seller;

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Long getProductCode() { return productCode; }
    public void setProductCode(Long productCode) { this.productCode = productCode; }
    public Category_23110362 getCategory() { return category; }
    public void setCategory(Category_23110362 category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public Integer getWishlist() { return wishlist; }
    public void setWishlist(Integer wishlist) { this.wishlist = wishlist; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
    public Seller_23110362 getSeller() { return seller; }
    public void setSeller(Seller_23110362 seller) { this.seller = seller; }
}


