package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query("select m from Message m"
		+ " where (m.user.id = :userId"
		+ " and m.userTo.id = :userIdTo)"
		+ " or (m.user.id = :userIdTo"
		+ " and m.userTo.id = :userId)")
	public List<Message> findByUserIds(@Param("userId") Integer userId, @Param("userIdTo") Integer userIdTo);
}
