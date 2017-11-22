package com.example.mvcproject.service;

import java.util.List;

import com.example.mvcproject.domain.Contact;

public interface ContactService {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public Contact findById(Integer contactId);
	public void delete(Integer[] contactIds);
	public List<Contact> findUserContact(Integer userId);
	public List<Contact> findUserContact(Integer userId, String txt);
	
}
