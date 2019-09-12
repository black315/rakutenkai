package com.rakuten.internship.service;

import com.rakuten.internship.entity.Tag;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public List<User> findUsersFromCity(String search_city) {
        return userRepository.findByCity(search_city);
    }

    public List<User> findUsersByCityAndTag(String city, Tag tag) {
        List<User> users = userRepository.findByCity(city).stream()
                .filter((userRepository.findByTags(Arrays.asList(tag))::contains))
                .collect(Collectors.toList());

        System.out.println(users);
        return users;
    }

    public List<User> findUsersByTag(Tag tag) {
        return userRepository.findByTags(Arrays.asList(tag));
    }

    public User findUserById(Integer id) {
        Optional<User> u = userRepository.findById(id);
        return u.orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
