package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Appointment;
import com.rakuten.internship.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByRequester(User requester);
}