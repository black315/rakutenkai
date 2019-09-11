package com.rakuten.internship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class SendDataForm {
    
    @Id
	public Integer tagId;
    

    @Column(name = "prefecture")
    private String prefecture;


    @Column(name = "prefecture")
    private String city;

}
