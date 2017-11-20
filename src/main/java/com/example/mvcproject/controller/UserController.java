package com.example.mvcproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvcproject.command.LoginCommand;
import com.example.mvcproject.command.UserCommand;
import com.example.mvcproject.domain.User;
import com.example.mvcproject.exception.UserBlockedException;
import com.example.mvcproject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","/index"})
	public String index(Model m)
	{
	m.addAttribute("command",new LoginCommand());
	return "index";
	}
	
	@RequestMapping(value= {"/login"}, method= RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session)
	{
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser==null) {
				m.addAttribute("err", "Login Failed! Enter Valid Credentials");
				return "index";
			}
			else
			{
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				}else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				}else {
					m.addAttribute("err","Invalid User Role");
					return "index";
				}
			}
		} catch (UserBlockedException ex) {
			m.addAttribute("err",ex.getMessage());
			return "index";
		}
	}
	
	@RequestMapping(value= {"/logout"})
	public String logout(HttpSession session)
	{
	session.invalidate();
	return "redirect:index?act=lo";
	}
	
	@RequestMapping(value= {"/user/dashboard"})
	public String userDashBoard()
	{
	return "dashboard_user";
	}
	
	@RequestMapping(value= {"/admin/dashboard"})
	public String adminDashBoard()
	{
	return "dashboard_admin";
	}
	
	@RequestMapping(value= {"/reg_form"})
	public String registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command",cmd);
		return "reg_form";
	}
	
	@RequestMapping(value= {"/register"})
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		User user = cmd.getUser();
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		return "redirect:index?act=reg";
	}
	
	private void addUserInSession(User u, HttpSession session)
	{
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role",u.getRole());
	}
}
