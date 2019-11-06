package com.bawei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.bean.User;
import com.bawei.mapper.UserDao;
import com.bawei.service.UserService;

/**
 * @author ccw
 *
 * 2019年11月5日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao ud;

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return ud.getUserList();
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		return ud.login(user);
	}

	public User checkuname(String uname) {
		// TODO Auto-generated method stub
		return ud.checkuname(uname);
	}

	
	
}
