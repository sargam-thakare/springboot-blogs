package com.sample.myfirstspringbootapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "myemployee")
public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", esalary=" + esalary + ", age=" + age + "]";
	}
	@Id    
	 @GeneratedValue
	private int id; 
	
	@Column
	String ename;
	
	@Column
	int esalary;
	
	@Column
	int age;
	
	public Employee(  String ename, int esalary, int age) {
		super();
		 
		this.ename = ename;
		this.esalary = esalary;
		this.age = age;
	}
	 
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsalary() {
		return esalary;
	}
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
