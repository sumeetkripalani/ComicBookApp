package com.example.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcproject.dao.BaseDAO;
import com.example.mvcproject.dao.ContactDAO;
import com.example.mvcproject.domain.Contact;
import com.example.mvcproject.rm.ContactRowMapper;
import com.example.mvcproject.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService
{
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.save(c);
	}

	@Override
	public void update(Contact c) {
		
		contactDAO.update(c);
		
	}

	@Override
	public void delete(Integer contactId) {
		// TODO Auto-generated method stub
		contactDAO.delete(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
		// TODO Auto-generated method stub
		String ids = StringUtil.toCommaSeperatedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		
		return contactDAO.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		String sql="SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),userId);
	}

	@Override
	public Contact findById(Integer contactId) {
			
		return contactDAO.findById(contactId);
	}

}
