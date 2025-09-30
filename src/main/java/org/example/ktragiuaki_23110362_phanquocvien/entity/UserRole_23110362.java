package org.example.ktragiuaki_23110362_phanquocvien.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole_23110362 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Integer roleId;

    @Column(name = "rolename", nullable = false, length = 50)
    private String roleName;

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}
