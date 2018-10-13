package com.zzu.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zzu.ssm.mapper.UserMapper;
import com.zzu.ssm.po.OrdersExt;
import com.zzu.ssm.po.User;
/**
 * 
 * @author Administrator
 * @date   2018年10月12日
 */
public class MyBatisMapperTest2 {
    
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void findOrdersListTest() throws Exception{
	
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper  userdao = session.getMapper(UserMapper.class);
			List<User> listUser = userdao.findUserAndOrderRstMap(1);
			for (User user : listUser) {
				user.getOrders();
			}
			} finally {
				if(session != null){
					session.close();
				}
			  
			}
		
	}
	
}
