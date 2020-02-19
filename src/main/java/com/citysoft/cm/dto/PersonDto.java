package com.citysoft.cm.dto;

import java.util.HashSet;
import java.util.Set;

import com.citysoft.cm.model.Gender;

public class PersonDto {

	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private TitleDto title;
	private AddressDto address;
	private Set<String> phones = new HashSet<>();
	private Set<String> emails = new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public TitleDto getTitle() {
		return title;
	}
	public void setTitle(TitleDto title) {
		this.title = title;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public Set<String> getPhones() {
		return phones;
	}
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	public Set<String> getEmails() {
		return emails;
	}
	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	


	
	
}
