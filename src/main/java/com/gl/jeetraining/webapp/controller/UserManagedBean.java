package com.gl.jeetraining.webapp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.gl.jeetraining.webapp.model.Role;
import com.gl.jeetraining.webapp.model.User;
import com.gl.jeetraining.webapp.service.IRoleService;
import com.gl.jeetraining.webapp.service.IUserService;

//@ManagedBean(name = "userMB")
//@RequestScoped
@Component("userBean")
@Scope("request")
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";

	private static final String ERROR = "error";

	private static final String REGSUCCESS = "regsuccess";

	private static final String USERLOG = "userlogsuccess";

	private static final String WOROLE = "withoutrole";

	// Spring User Service is injected...
	// @ManagedProperty(value = "#{UserService}")
	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	List<User> userList;

	List<Role> roleList;

	private int id;

	private String name;

	private String surname;

	private String login;

	private String password;

	private String email;

	private String hobbie;

	private String note;

	private Role role;

	private String description;

	private Integer roleId;

	public String login() {
		try {
			User user = userService.getUserByRegInf(login, password);
			if (user != null) {
				Role role = user.getRole();
				if (role == null) {
					return WOROLE;
				} else if (role.getDescription().equals("simple")) {
					return USERLOG;
				} else if (role.getDescription().equals("admin")) {
					return SUCCESS;
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String addUser() {
		try {
			if (userService.getUserByRegInf(login, password) != null) {
				return ERROR;
			} else {
				User user = new User();
				user.setName(getName());
				user.setSurname(getSurname());
				user.setEmail(getEmail());
				user.setLogin(getLogin());
				user.setPassword(getPassword());
				user.setHobbie(getHobbie());
				user.setNote(getNote());
				userService.addUser(user);
				return REGSUCCESS;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public String setRole() {
		try {

			Role role = new Role();
			role.setDescription(getDescription());
			userService.setRole(role);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Role> getRoleList() {

		roleList = new ArrayList<Role>();
		roleList.addAll(getUserService().getRoles());

		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String deleteUser(User user) {
		try {
			getUserService().deleteUser(user);
			userList = null;
			getUserList();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public Role getRole() {
		return role;
	}

	public String getRoleCurrentUser(Role role) {
		User user = userService.getUserByRegInf(login, password);
		role = user.getRole();
		return role.getDescription();
	}

	public String getRole(User user) {
		try {

			Role role = user.getRole();
			if (role == null) {
				return "W/O role";
			}
			return role.getDescription();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
		this.setLogin("");
		this.setPassword("");
	}

	public List<User> getUserList() {
		if (userList == null) {
			userList = new ArrayList<User>();
			userList.addAll(getUserService().getUsers());
		}
		return userList;
	}

	public String updateRole(User user) {
		try {
			// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " +
			// roleId);
			Role userRole = roleService.getRole(roleId);
			user.setRole(userRole);

			userService.updateUser(user);

			return SUCCESS;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobbie() {
		return hobbie;
	}

	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}