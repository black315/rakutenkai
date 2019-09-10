package com.rakuten.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Messages {
    
    @Id
    @GeneratedValue(generator= "my_gen")
    @GenericGenerator(name= "my_gen", strategy= "increment")
    private Long room_id;
    
    @NotBlank(message = "Title is mandatory")
    @JoinColumn(name = "User_id")
    private User user;
    
    @NotBlank(message = "Description is mandatory")
     @Column(name = "Content")
    private List<String> content;

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
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the content
	 */
	public List<String> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<String> content) {
		this.content = content;
	}
    
}