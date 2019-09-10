package com.rakuten.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
    
    @Id
    @GeneratedValue(generator= "my_gen")
    @GenericGenerator(name= "my_gen", strategy= "increment")
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Column(name = "Title")
    private String name;
    
    @NotBlank(message = "Description is mandatory")
     @Column(name = "Languages")
    private List<String> languages;
    
    @NotBlank(message = "Description is mandatory")
     @Column(name = "Review")
    private int review;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the languages
	 */
	public List<String> getLanguages() {
		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	/**
	 * @return the review
	 */
	public int getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(int review) {
		this.review = review;
	}

}
