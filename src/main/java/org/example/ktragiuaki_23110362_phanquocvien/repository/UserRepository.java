package org.example.ktragiuaki_23110362_phanquocvien.repository;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User_23110362, Integer> {
    Optional<User_23110362> findByUsernameAndPassword(String username, String password);
    Optional<User_23110362> findByUsername(String username);
}


