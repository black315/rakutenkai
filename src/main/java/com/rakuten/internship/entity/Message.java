package com.rakuten.internship.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class Message {
    
    @Id
    @GeneratedValue(generator= "my_gen")
    @GenericGenerator(name= "my_gen", strategy= "increment")
    private Long id;

	@NotBlank
	private Long room_id;
    
    @NotBlank(message = "User is mandatory")
//    @JoinColumn(name = "User_id")
	@ManyToOne
	private User user;

	@NotBlank(message = "Description is mandatory")
	@Column(name = "Content")
	private String content;

	@NotBlank
	private String timestamp;


}