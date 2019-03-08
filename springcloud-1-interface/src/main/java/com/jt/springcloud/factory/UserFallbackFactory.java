package com.jt.springcloud.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

import feign.hystrix.FallbackFactory;
import lombok.extern.apachecommons.CommonsLog;
@ComponentScan
public class UserFallbackFactory  implements FallbackFactory<UserService>{

	@Override
	public UserService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new UserService() {
			//该结婚口的方法完成当提供者出错时返回有效的机制
			@Override
			public String updateUser(User user) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String saveUser(@RequestBody User user) {
				// TODO Auto-generated method stub
				return "后台服务异常";
			}
			
			@Override
			public List<User> findAll() {
				List<User> userList = 
						new ArrayList<User>();
				User user = new User();
				user.setId(0).setName("后台服务器异常").setAge(0)
				.setSex("");
				userList.add(user);
				return userList;

			}
			
			@Override
			public String deleteUser(Integer id) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
