package com.sample.myfirstspringbootapp.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.myfirstspringbootapp.Entity.Blogs;
import com.sample.myfirstspringbootapp.Entity.Employee;
import com.sample.myfirstspringbootapp.Entity.userEntity;
import com.sample.myfirstspringbootapp.services.BlogServices;
import com.sample.myfirstspringbootapp.services.empservices;
import com.sample.myfirstspringbootapp.services.userService;

@Controller
@RequestMapping("/employee")
public class MyControllernew {

	@Autowired
	userService userservices;
	
	@Autowired
	BlogServices blogservice;

	@GetMapping("/homeee")
	public String homejsp() {

		return "home";
	}

	@GetMapping("/indexx")
	public String index() {

		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {

		return "login";
	}

	@GetMapping("/register")
	public String register() {

		return "registration";
	}

	@PostMapping("/saveEmployeedetails")
	@ResponseBody
	public String saveEmployeedetails(@RequestBody userEntity user) {

		userservices.saveUser(user);
		return "my emp details " + user + " saved succesfully";
	}

	@GetMapping(value = "/getEmployeedetails")
	@ResponseBody
	public String getEmployeedetails(@RequestParam("mynewid") int myid) {
		Optional<userEntity> emp = userservices.getUserDetails(myid);
		return "my emp details " + emp;
	}

	@RequestMapping(path = "/dashboard", method = RequestMethod.POST)
	public String greetingForm(@RequestParam("username_student") String username,
			@RequestParam("password_student") String password, Model model,HttpSession session) {
		// model.addAttribute("greeting", new Greeting());

		System.out.println("username " + username);
		System.out.println("password " + password);
		
		

		model.addAttribute("username", username);
		model.addAttribute("password", password);

		 
	    userEntity user=userservices.findUserWithNameandPassword(username, password);
	     if(user!=null) {
	    	 session.setAttribute("userId", user.getUserId());
	    	 return "home";
	     }
		  model.addAttribute("isloggedin", false);
		  return "login";
	} 

	@RequestMapping(path = "/registerUser", method = RequestMethod.POST )
	public String createuser(@Validated userEntity user, Model model,HttpSession session) {

		System.out.println("user " + user);
		System.out.println("user11 " + user.getUsername());

		  userEntity user2=userservices.findUserWithNameandPassword(user.getUsername(), user.getPassword());
		     if(user2!=null) {
 		    	 
		     
			model.addAttribute("userexist");
			return "registration";
		}
		return "login";

	}

	@RequestMapping(path = "/blogList", method = RequestMethod.POST)
	public String blogList(Model model,HttpSession session) {
		
		int userId=(int) session.getAttribute("userId");
		List<Blogs> blogs=blogservice.getBlogsByUserId(userId);
		
		model.addAttribute("blogs", blogs);
		
		return "blogList";

	}

	@RequestMapping(path = "/createBlog", method = RequestMethod.POST)
	public String createBlog() {
		return "createBlog";
	}

	@RequestMapping(path = "/saveBlog", method = RequestMethod.POST)
	public String saveUser(@Validated Blogs blog, Model model,HttpSession session) {

		int userId=(int) session.getAttribute("userId");
		
		blog.setUserId(userId);
		System.out.println("blog  "+blog+" userId"+userId);

		blogservice.saveBlog(blog);
		return "home";
	}
}
