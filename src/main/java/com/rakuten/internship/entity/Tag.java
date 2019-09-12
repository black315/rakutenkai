package com.rakuten.internship.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "Name")
    private String name;

}
