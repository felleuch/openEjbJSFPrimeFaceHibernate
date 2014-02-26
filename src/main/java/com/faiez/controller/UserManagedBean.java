package com.faiez.controller;

import com.faiez.domain.User;
import com.faiez.ejb.UserBeanLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name="userMB")
@RequestScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";


	@EJB
	private UserBeanLocal userBean;
	
	List<User> userList;
	
	private int id;
	private String fullname;
	private String email;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */
	public String addUser() {

			User user = new User();
			//user.setId(getId());
			user.setEmail(getEmail());
			user.setFullname(getFullname());
			userBean.addUser(user);



		return SUCCESS;
	}

	public void reset() {
		this.setId(0);
		this.setFullname("");
		this.setEmail("");
	}

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(userBean.getUsers());
		return userList;
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




	
}