package com.rakuten.internship.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User requester;

    @ManyToOne
    private User requested;
    private String date;
    private String city;
    private String place;
    private String details;

    @ManyToOne
    private Tag tag;

}
