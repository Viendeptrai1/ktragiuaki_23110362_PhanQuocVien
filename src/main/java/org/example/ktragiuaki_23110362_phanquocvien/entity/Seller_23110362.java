package org.example.ktragiuaki_23110362_phanquocvien.entity;

import javax.persistence.*;

@Entity
@Table(name = "Seller")
public class Seller_23110362 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerid")
    private Integer sellerId;

    @Column(name = "sellername", nullable = false, length = 50)
    private String sellerName;

    @Column(name = "images")
    private String images;

    @Column(name = "status")
    private Integer status;

    public Integer getSellerId() { return sellerId; }
    public void setSellerId(Integer sellerId) { this.sellerId = sellerId; }
    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
