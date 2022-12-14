package com.te.hds.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery_person")
public class DeliveryPersonDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryPersonId;
	private String deliveryGuyName;
	private String location;
	private String availableFrom;
	private String availableTo;
	private boolean availability;
	private float rating;
	
}
