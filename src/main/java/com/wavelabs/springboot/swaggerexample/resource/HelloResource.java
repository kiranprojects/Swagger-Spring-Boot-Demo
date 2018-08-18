package com.wavelabs.springboot.swaggerexample.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/hello")
@Api(value="Hello World Resource", description="hello world")
public class HelloResource {

	@ApiOperation(value="Returns Hello World!")
	@ApiResponses(value= {
			@ApiResponse(code = 100 , message = "Failure"),
			@ApiResponse(code = 200 , message = "Success"),
	})
	@GetMapping
	public String helloWorld() {
		return "Hello World!";
	}
	
	@ApiOperation(value="Returns what ever the string is given")
	@ApiResponses(value= {
			@ApiResponse(code = 100 , message = "Failure"),
			@ApiResponse(code = 200 , message = "Success"),
	})
	@PostMapping("/helloWorldPost")
	public String helloWorldPost(@RequestBody final String helloWorld) {
		return helloWorld;
	}
	
	@ApiOperation(value="Returns what ever the string is given")
	@ApiResponses(value= {
			@ApiResponse(code = 100 , message = "Failure"),
			@ApiResponse(code = 200 , message = "Success"),
	})
	@PutMapping("/helloWorldPut")
	public String helloWorldPut(@RequestBody final String helloWorld) {
		return helloWorld;
	}
}
