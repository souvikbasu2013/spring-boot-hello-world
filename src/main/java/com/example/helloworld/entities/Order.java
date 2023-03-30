package com.example.helloworld.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "This model is to create an Order")
@Entity
@Table(name = "sys_order")
@Data
@NoArgsConstructor
public class Order {
	
	@ApiModelProperty(notes = "Auto generated unique id", required = true)
	@Id
	@GeneratedValue
	private Long orderId;
	
	@ApiModelProperty(notes = "Order description")
	@Column(name = "ORDER_DESC")
	private String orderDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	User user;
	
}
