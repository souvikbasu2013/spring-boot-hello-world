package com.example.helloworld.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "This model is to create a User")
@Entity(name="Users")
@Table(name="sys_app_user")
@Validated
@Data
@NoArgsConstructor
public class User {

	@ApiModelProperty(notes = "Auto generated unique id", required = true)
	@Id
	private Long id;
	
	@ApiModelProperty(notes = "User full name", required = true)
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@NotEmpty(message = "User Name can not be empty")
	private String username;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = true)
	@Size(min = 2,message = "First Name should be atleast 2 characters")
	private String firstname;
	
	@Column(name = "LAST_NAME", length = 50, nullable = true)
	private String lastname;
	
	@Column(name = "EMAIL_ADDRESS", length = 50, nullable = true)
	private String email;
	
	@Column(name = "ROLE", length = 50, nullable = true)
	private String role;
	
	@ApiModelProperty(notes = "Social Security Number", required = true)
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	List<Order> orders;
	
}
