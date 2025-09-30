package org.example.ktragiuaki_23110362_phanquocvien.service;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.entity.UserRole_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.repository.UserRepository;
import org.example.ktragiuaki_23110362_phanquocvien.repository.UserRoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService_23110362 {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public AuthService_23110362(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public Optional<User_23110362> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Transactional
    public User_23110362 register(String username, String password, String fullname, String email, boolean isSeller) {
        User_23110362 user = new User_23110362();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setStatus(1);

        String roleName = isSeller ? "ADMIN" : "USER"; // theo đề: User/Seller (seller ~ admin trang quản trị)
        UserRole_23110362 role = userRoleRepository.findByRoleName(roleName)
                .orElseGet(() -> {
                    UserRole_23110362 r = new UserRole_23110362();
                    r.setRoleName(roleName);
                    return userRoleRepository.save(r);
                });
        user.setRole(role);
        return userRepository.save(user);
    }
}
