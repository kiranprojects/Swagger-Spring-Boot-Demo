package com.wavelabs.springboot.swaggerexample.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/user")
@Api(value="User Resource", description="shows user inormation")
public class UserResource {
	
	@ApiOperation(value="Returns All the users")
	@ApiResponses(value= {
			@ApiResponse(code = 100 , message = "Failure"),
			@ApiResponse(code = 200 , message = "Success"),
	})
	@GetMapping
	public List<User> getUsers(){
		return Arrays.asList(new User("Kiran",1000), new User("Satish", 2000));
	}
	
	@ApiOperation(value="Returns what ever use name you given")
	@ApiResponses(value= {
			@ApiResponse(code = 100 , message = "Failure"),
			@ApiResponse(code = 500 , message = "Success"),
	})
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") final String userName){
		return new User(userName,1000);
	}
	
	private class User{
		@ApiModelProperty(notes = "name of the user")
		private String name;
		@ApiModelProperty(notes = "salary of the user")
		private int salary;
		
		public User(String name, int salary) {
			this.name = name;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		
		
	}

}
