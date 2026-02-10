package com.unstay.server.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unstay.server.repository.UserRepository; 
import com.unstay.server.entity.User;  

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
    
}
