package com.yan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RoleBean implements Serializable {
	private static final long serialVersionUID = 5826993177949986331L;
	private Long id;
	private String name;
	private Set<UserBean> users = new HashSet<>(0);
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<UserBean> getUsers() {
		return users;
	}
	public void setUsers(Set<UserBean> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", name=" + name + "]";
	}

}
