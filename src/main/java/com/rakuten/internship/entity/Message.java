package com.rakuten.internship.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
	private Long room_id;
    
    @NotBlank(message = "User is mandatory")
//    @JoinColumn(name = "User_id")
	@ManyToOne
	private User user;
    
    @ManyToOne
    private User userTo;

	@NotBlank(message = "Description is mandatory")
	@Column(name = "Content")
	private String content;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	
	@Column(name = "private_message")
	private boolean privateMessage;
	
}