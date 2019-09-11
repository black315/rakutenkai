package com.rakuten.internship.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "Name")
    private String name;
    
    //@NotBlank(message = "Languages is mandatory")
	@Column(name = "Languages")
	@ElementCollection(targetClass=String.class)
    private List<String> languages;
    
    //@NotBlank(message = "Rating is mandatory")
	@Column(name = "Rating")
    private int rating;

	@OneToMany(mappedBy = "user")
	private List<Message> messages;

	private String country;
	private String city;
	private String username;
	private String role;
	private String birthdate;
	private String gender;
	private String pictureUrl;
	private String selfIntroduction;

}
