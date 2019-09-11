package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Tag;
import com.rakuten.internship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByCity(String city);
    List<User> findByTags(List<Tag> tags);
}
