package com.unstay.server.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.unstay.server.entity.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    
}
