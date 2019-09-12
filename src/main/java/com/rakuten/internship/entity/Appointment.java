package com.rakuten.internship.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private User requester;
    private User requested;
    private String data;
    private String place;
    private String details;
    private Tag tag;

}
