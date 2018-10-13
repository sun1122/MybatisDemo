package com.zzu.ssm.mapper;

import java.util.List;

import com.zzu.ssm.po.OrdersExt;
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
	/**
	 * 测试resultMap映射
	 * 一对一关联查询时，可以定义专门的扩展po类作为输出结果类型
	 * @return
	 */
	public List<OrdersExt> findOrdersList();
	
	
	public List<OrdersExt> findOrdersAndUserRstMap() throws Exception;
	/**
	 * 测试resultMap映射
	 * 一对多关联查询时
	 * @return
	 */
	public List<User> findUserAndOrderRstMap(int id) throws Exception; 
}
