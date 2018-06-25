package com.yan.provider;

import java.util.Map;

public class UserSqlProvider {
	public String getMapSql(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("select * from t_users where 1=1");
		if (map != null) {
			if (map.containsKey("id")) {
				sb.append(" and id=#{id}");
			}
			if(map.containsKey("username"))
				sb.append(" and username=#{username}");
			if(map.containsKey("password"))
				sb.append(" and password=#{password}");
		}
		return sb.toString();
	}
}
