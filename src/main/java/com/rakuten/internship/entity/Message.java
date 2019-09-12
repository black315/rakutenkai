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

	@NotBlank(message = "Description is mandatory")
	@Column(name = "Content")
	private String content;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	
	@Column(name = "private_message")
	private boolean privateMessage;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the room_id
	 */
	public Long getRoom_id() {
		return room_id;
	}

	/**
	 * @param room_id the room_id to set
	 */
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the privateMessage
	 */
	public boolean isPrivateMessage() {
		return privateMessage;
	}

	/**
	 * @param privateMessage the privateMessage to set
	 */
	public void setPrivateMessage(boolean privateMessage) {
		this.privateMessage = privateMessage;
	}

}