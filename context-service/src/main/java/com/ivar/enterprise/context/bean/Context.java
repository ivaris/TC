package com.ivar.enterprise.context.bean;

import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by ONC50886 on 8/15/2016.
 */
public class Context implements Serializable {
	
	String firstName;
	String lastName;
	String middleInital;
	String fullName;
	
	String emailAddress;
	Phone phoneNumber;
	String username;
	int userId;
	Address primaryAddreess;
	Address mailingAddress;
	String country;
	Locale userLocale;
	Currency curreny;
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
	public String getMiddleInital() {
		return middleInital;
	}
	public void setMiddleInital(String middleInital) {
		this.middleInital = middleInital;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Phone getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Address getPrimaryAddreess() {
		return primaryAddreess;
	}
	public void setPrimaryAddreess(Address primaryAddreess) {
		this.primaryAddreess = primaryAddreess;
	}
	public Address getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Locale getUserLocale() {
		return userLocale;
	}
	public void setUserLocale(Locale userLocale) {
		this.userLocale = userLocale;
	}
	public Currency getCurreny() {
		return curreny;
	}
	public void setCurreny(Currency curreny) {
		this.curreny = curreny;
	}
	
	
	
	
}
