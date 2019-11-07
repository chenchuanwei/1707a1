package com.bawei.service;

import java.util.List;

import com.bawei.bean.User;

/**
 * @author ccw
 *
 * 2019年11月5日
 */
public interface UserService {

	List<User> getUserList();

	User login(User user);

	User checkuname(String uname);

	Integer register(User user);


}
