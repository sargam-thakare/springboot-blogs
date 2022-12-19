package com.sample.myfirstspringbootapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sample.myfirstspringbootapp.Entity.Employee;
import com.sample.myfirstspringbootapp.Entity.Blogs;
import com.sample.myfirstspringbootapp.repository.BlogsRepo;
import com.sample.myfirstspringbootapp.repository.userRepo;
 

 
@Component
@Service
public class BlogServices {

	@Autowired
	BlogsRepo blogsrepo;
	
	
	public Optional<Blogs> getBlogDetails(int id) {
		return blogsrepo.findById(id);
		
		
	}
	public void saveBlog(Blogs blog) {
		
		System.out.println("blog in service "+blog);
		blogsrepo.save(blog);
		
	}
	public List<Blogs> getBlogsByUserId(int userId) {
		
		return blogsrepo.FindByUserId(userId);
		
		
	}
	
	
	 
}
