package com.bawei.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.bean.User;
import com.bawei.service.UserService;
import com.bawei.util.FileUtils;
import com.bawei.util.MD5Util;

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
	
	@RequestMapping("register")
	public String register(User user,MultipartFile photo) throws IllegalStateException, IOException{
		
		Date d=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String created = sdf.format(d);
		
		user.setCreated(created);
		
		String picture = FileUtils.upload(photo);
		
		user.setPicture(picture);
		
		String pwd = MD5Util.encode(user.getPwd());
		
		user.setPwd(pwd);
		
		Integer i=us.register(user);
		
		if(i>0){
			return "redirect:getUserList";
		}else{
			return "register";
		}
	}
	
	@RequestMapping("lockPicture")
	public void lockPicture(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	@RequestMapping("look")
	@ResponseBody
	public User look(String uname){
		
		User user = us.checkuname(uname);
		
		return user;
	}
}
