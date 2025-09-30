package org.example.ktragiuaki_23110362_phanquocvien.entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User_23110362 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "fullname", length = 50)
    private String fullname;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "images", length = 500)
    private String images;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "code", length = 50)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    private UserRole_23110362 role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellerid")
    private Seller_23110362 seller;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public UserRole_23110362 getRole() { return role; }
    public void setRole(UserRole_23110362 role) { this.role = role; }
    public Seller_23110362 getSeller() { return seller; }
    public void setSeller(Seller_23110362 seller) { this.seller = seller; }
}


