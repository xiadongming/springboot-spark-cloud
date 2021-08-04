package com.example.demo.stream.model;

public class Address
{
	private Long id;
	private String streetName;
	private String apartmentOrHouseNumber;
	private String city;
	private Long zipCode;
	private String state;
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentOrHouseNumber() {
		return apartmentOrHouseNumber;
	}

	public void setApartmentOrHouseNumber(String apartmentOrHouseNumber) {
		this.apartmentOrHouseNumber = apartmentOrHouseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address()
	{
		super();
		id = 0L;
	}
}
