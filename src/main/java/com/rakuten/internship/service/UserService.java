package com.rakuten.internship.service;

import com.rakuten.internship.entity.User;
import com.rakuten.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id) {
        Optional<User> u = userRepository.findById(id);
        return u.orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
