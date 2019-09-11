package com.rakuten.internship.service;

import com.rakuten.internship.entity.Tag;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUsersFromCity(String search_city) {
        return userRepository.findByCity(search_city);
    }

    public List<User> findUsersByTag(Tag tag) {
        return userRepository.findByTags(Arrays.asList(tag));
    }
}
