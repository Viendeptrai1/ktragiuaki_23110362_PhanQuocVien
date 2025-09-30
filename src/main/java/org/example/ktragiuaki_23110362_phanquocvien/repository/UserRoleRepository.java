package org.example.ktragiuaki_23110362_phanquocvien.repository;

import org.example.ktragiuaki_23110362_phanquocvien.entity.UserRole_23110362;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole_23110362, Integer> {
    Optional<UserRole_23110362> findByRoleName(String roleName);
}


