package com.example.mvcproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.mvcproject.dao.BaseDAO;
import com.example.mvcproject.dao.UserDAO;
import com.example.mvcproject.domain.User;
import com.example.mvcproject.exception.UserBlockedException;
import com.example.mvcproject.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		/**
		 *  @param loginName 
		 * @param password
		 */
		userDAO.save(u);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql= "SELECT userId, name, phone, email, address, role, loginStatus, loginName" + " FROM user WHERE loginName=:ln AND password=:pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try
		{
			User u= getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED))
			{
				throw new UserBlockedException("Your Account Has Been Blocked. Contact To Admin");
			}else
			{
				return u;
			}
		}catch(EmptyResultDataAccessException ex){
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}



}
