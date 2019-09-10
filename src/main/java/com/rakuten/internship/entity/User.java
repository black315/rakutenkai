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
    @GeneratedValue(generator= "my_gen")
    @GenericGenerator(name= "my_gen", strategy= "increment")
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Column(name = "Title")
    private String name;
    
    @NotBlank(message = "Languages is mandatory")
	@Column(name = "Languages")
	@ElementCollection(targetClass=String.class)
    private List<String> languages;
    
    @NotBlank(message = "Description is mandatory")
     @Column(name = "Review")
    private int review;

	@OneToMany(mappedBy = "user")
	private List<Message> messages;

}
