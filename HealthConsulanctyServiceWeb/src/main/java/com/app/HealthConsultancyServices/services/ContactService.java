package com.app.HealthConsultancyServices.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.HealthConsultancyServices.model.Contact;
import com.app.HealthConsultancyServices.repository.ContactRepository;

@Service
@Transactional
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	
	public List<Contact> getAllContact()   
	{  
	List<Contact> contact = new ArrayList<Contact>();  
	contactRepository.findAll().forEach(contact1 -> contact.add(contact1));  
	return contact;  
	}
	
	public Contact saveOrUpdate(Contact contact)   
	{  
		return contactRepository.save(contact);  
	} 
	
}
