package com.yan.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.yan.dao.UserMapper;
import com.yan.entity.UserBean;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServImpl implements IUserServ {
	@Autowired
	private UserMapper userMapper;
	private Logger logger = LoggerFactory.getLogger(UserServImpl.class);

	@Override
	public boolean login(UserBean user) {
		logger.debug("先进行业务校验");
		Assert.notNull(user, "参数错误!");
		Assert.hasText(user.getUsername(), "参数错误!");
		Assert.hasText(user.getPassword(), "参数错误!");
		logger.debug("业务校验通过");
		Map<String, Object> map = new HashMap<>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		List<UserBean> ulist = userMapper.selectByMap(map);
		if (ulist != null && ulist.size() > 0) {
			UserBean temp = ulist.get(0);
			BeanUtils.copyProperties(temp, user);
			return true;
		}
		return false;
	}

}
