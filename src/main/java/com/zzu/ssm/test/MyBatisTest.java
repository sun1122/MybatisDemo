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

import com.zzu.ssm.po.User;

public class MyBatisTest {
    
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void getSqlSessionFactory() throws IOException{
		//指定全局配置文件路径
		String resource = "mybatis-config.xml";
		//加载资源文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//使用构建者模式，去创建SqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindUserById(){
	
		SqlSession session = sqlSessionFactory.openSession();
		try {
			  User user = (User) session.selectOne("com.zzu.ssm.mapper.UserMapper.findUserById", 1);
			  System.out.println(user);
			} finally {
				if(session != null){
					session.close();
				}
			  
			}
		
	}
	
	@Test
	public void TestFindUserByUsername(){
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 查询单个记录，根据用户id查询用户信息
			List<User> list = sqlSession.selectList("findUserByUsername", "小明");
			System.out.println(list.size());
			
			for (User user : list) {
				System.out.println("----");
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void TestInsertUser(){
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setUsername("刘小三");
			user.setAddress("河南郑州");
			user.setSex("1");
			  
			//由于JAVA的基本数据类型会有默认值，例如  private int age ，创建这个类时，会有默认值0； 当时用这个属性时，他总会有值。
			//因此在判断age为null无法实现。所以在实体类中不要使用基本类型
			//byte 、 int 、short 、long、 float 、 double 、 char 、boolean
			int i = sqlSession.insert("insertUser", user);// int 默认值为0 修改为 integer类型
            //System.out.println(i);
			Assert.assertEquals(1, i);
			Assert.assertNotNull(user.getId());
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void TestInsertUserReturnKey(){
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setUsername("刘小二");
			user.setAddress("河南安阳");
			user.setSex("1");
			
			int i = sqlSession.insert("insertUserReturnKey", user);
            System.out.println(i);
			
            Assert.assertEquals(1, i);
			Assert.assertNotNull(user.getId());
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void TestDeleteUserById(){
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setUsername("刘小二");
			user.setAddress("河南安阳");
			user.setSex("1");
			
			int i = sqlSession.delete("deleteUserById", 53);
            Assert.assertEquals(1, i);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void TestUpdateUser(){
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setId(41);
			user.setUsername("刘小二");
			user.setAddress("河南安阳北关");
			user.setSex("1");
			
			int i = sqlSession.update("updateUser", user);
            Assert.assertEquals(1, i);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
