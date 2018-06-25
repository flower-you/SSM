package com.yan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.yan.group.UserGroup;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 408151035757216789L;
	private Long id;
	@NotEmpty(groups = UserGroup.LoginFirstGroup.class, message = "用户名称不能为空!")
	@Size(min = 6, max = 20, groups = UserGroup.LoginSecondGroup.class, message = "用户名称应该在6到20个字符之间!")
	private String username;
	@NotEmpty(groups = UserGroup.LoginFirstGroup.class, message = "用户口令不能为空!")
	@Size(min = 6, max = 20, groups = UserGroup.LoginSecondGroup.class, message = "用户口令应该在6到20个字符之间!")
	private String password;
	private Date birth;
	private Boolean sex;
	private Long roleId;
	private RoleBean role;
	private String pic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
