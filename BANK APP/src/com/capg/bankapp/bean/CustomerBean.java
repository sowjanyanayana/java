package com.capg.bankapp.bean;

import java.util.Date;

public class CustomerBean {

	private Long phNo;
	private double balance;
	private Long phNo2;
	private int age;
	private String firstName;
	private String lastName;
	private Long adhar;
	private Date date;
	public Long getPhNo() {
		return phNo;
	}
	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}
	public double getBalance() {
		return balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Long getPhNo2() {
		return phNo2;
	}
	public void setPhNo2(Long phNo2) {
		this.phNo2 = phNo2;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public Long getAdhar() {
		return adhar;
	}
	public void setAdhar(Long adhar) {
		this.adhar = adhar;
	}
	@Override
	public String toString() {
		return "BankBean [phNo=" + phNo + ", balance=" + balance + ", phNo2=" + phNo2 + ", age=" + age + ", firstName="
				+ firstName + ", lastName=" + lastName + ", adhar=" + adhar + "]";
	}
	
	

}
