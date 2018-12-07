package com.allen.repository;

import com.allen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findById(long id);
    
    void deleteById(Long id);
}