package com.bawei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.bean.User;
import com.bawei.service.UserService;

/**
 * @author ccw
 *
 * 2019年11月5日
 */
@Controller
public class UserController {

	@Resource
	private UserService us;
	
	@RequestMapping("getUserList")
	public String getUserList(Model model){
		
		List<User> list=us.getUserList();
		
		model.addAttribute("list", list);
		
		return "UserList";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public User login(User user,HttpSession session){
		
		User u=us.login(user);
		
		if(u!=null){
			
			session.setAttribute("u", u);
			
			return u;
		}else{
			return u;
		}
	}
	
	@RequestMapping("checkuname")
	@ResponseBody
	public User checkuname(String uname){
		
		User user=us.checkuname(uname);
		
		return user;
	}
}
