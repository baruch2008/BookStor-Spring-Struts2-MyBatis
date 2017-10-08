package com.baruch.action;

//import org.apache.struts2.convention.annotation.AllowedMethods;

import com.baruch.model.User;
import com.opensymphony.xwork2.ActionSupport;

//@AllowedMethods
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 4587999901909926995L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String index() {
		return "login";
	}

	public String login() {
		if ("admin".equals(user.getName()) && "12345".equals(user.getPwd())) {
			return "success";
		} else {
			return "error";
		}
	}
}
