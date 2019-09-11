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
		+ " where m.room_id = :roomId"
		+ " and m.user.id in :userIds")
	public List<Message> findByRoomIdAndUserIds(@Param("roomId") Long roomId, @Param("userIds") List<Long> userIds);
}
