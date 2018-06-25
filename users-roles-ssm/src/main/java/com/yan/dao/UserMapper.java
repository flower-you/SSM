package com.yan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.yan.entity.UserBean;
import com.yan.provider.UserSqlProvider;

@Mapper
public interface UserMapper {
	@SelectProvider(type = UserSqlProvider.class,method="getMapSql")
	List<UserBean> selectByMap(Map<String, Object> map);
}
