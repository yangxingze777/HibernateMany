package com.yxz.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "address")
public class AddressModel implements Serializable{

	private static final long serialVersionUID = -4386499351484974425L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;

	public AddressModel() {
		super();
	}

	public AddressModel(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getStreet() {
		return street;
	}

	@Override
	public String toString() {
		return "AddressModel [Id=" + Id + ", street=" + street + ", city=" + city + "]";
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
