package org.example.ktragiuaki_23110362_phanquocvien.service;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService_23110362 {
    private final UserRepository userRepository;

    public UserService_23110362(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User_23110362> findPage(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<User_23110362> findById(Integer id) { return userRepository.findById(id); }
    public User_23110362 save(User_23110362 u) { return userRepository.save(u); }
    public void deleteById(Integer id) { userRepository.deleteById(id); }
}


