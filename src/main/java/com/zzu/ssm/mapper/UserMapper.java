package com.zzu.ssm.mapper;

import java.util.List;

import com.zzu.ssm.po.User;

public interface UserMapper {

	public User findUserById(int id);
	
	public List<User> findUserByUsername(String  name);
	
	public int insertUser(User user);
	
	public int insertUserReturnKey(User user);
	
	public int deleteUserById(int id);
	
	public int updateUser(User user);
	/**
	 * 测试resultMap映射
	 * @return
	 */
	public List<User> findUserListResultMap(); 
}
