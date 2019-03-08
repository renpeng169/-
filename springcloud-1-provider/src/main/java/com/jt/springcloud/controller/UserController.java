package com.jt.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping("/findAll")
	@HystrixCommand(fallbackMethod="hystrix_findAll")
	public List<User> findAll(){
		System.out.println("这是第一个服务器");
		//throw new RuntimeException();
		return userService.findAll();
	}
	public List<User> hystrix_findAll(){
		User user = new User();
		user.setId(0);
		user.setName("后台服务器异常");
		user.setAge(0);
		user.setSex("");
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		return userList; 
	}
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
		
	}
	@RequestMapping("/delUser")
	public String delUser(Integer id ) {
		return userService.delUser(id);
	}
	@RequestMapping("/update")
	public String update(@RequestBody User user) {
		return userService.update(user);
		
		
	}
	
}
