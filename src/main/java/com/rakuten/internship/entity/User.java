package com.rakuten.internship.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "Name")
    private String name;
    
    @NotBlank(message = "Languages is mandatory")
	@Column(name = "Languages")
	@ElementCollection(targetClass=String.class)
    private List<String> languages;
    
    @NotBlank(message = "Rating is mandatory")
	@Column(name = "Rating")
    private int rating;

	@OneToMany(mappedBy = "user")
	private List<Message> messages;

	@ManyToMany
//	@JoinTable(
//			name = "handle_tags",
	//			joinColumns = @JoinColumn(name = "id"),
//			inverseJoinColumns = @JoinColumn(name = "tagId"))
	private List<Tag> tags;

	private String country;
	private String city;
	private String username;
	private String role;
	private String birthdate;
	private String gender;
	private String pictureUrl;
	private String selfIntroduction;

	private float longitude;
	private float latitude;

}
