package com.yan.biz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yan.entity.UserBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServTest {
	@Autowired
	private IUserServ userv;
	@Test(expected=RuntimeException.class)
	public void testLogin() {
		UserBean user=new UserBean();
		boolean bb=userv.login(user);
		assertFalse(bb);
	}
	@Test
	public void testLogin2() {
		UserBean user=new UserBean();
		user.setUsername("yanjun");
		user.setPassword("123456");
		boolean bb=userv.login(user);
		assertTrue(bb);
	}
}
