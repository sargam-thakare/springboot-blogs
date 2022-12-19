package com.sample.myfirstspringbootapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Blogs")
public class Blogs {
	
	@Override
	public String toString() {
		return "Blogs [id=" + id + ", userId=" + userId + ", blogTitle=" + blogTitle + ", blogDescription="
				+ blogDescription + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	@Id    
	 @GeneratedValue
	private int id; 
	
	@Column
	int userId;
	
	@Column
	String blogTitle;
	
	@Column
	String blogDescription;
 
}
