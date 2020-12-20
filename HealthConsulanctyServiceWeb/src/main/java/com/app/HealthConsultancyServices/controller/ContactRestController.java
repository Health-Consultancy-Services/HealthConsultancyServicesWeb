package com.app.HealthConsultancyServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.HealthConsultancyServices.model.Contact;
import com.app.HealthConsultancyServices.services.ContactService;
@RestController 
public class ContactRestController {
	@Autowired
	ContactService contactService;
	
	@PostMapping("/contact")  
	private Contact savContact(@RequestBody Contact contact)    
		{  
		Contact message = null;
	        try {
	            message = contactService.saveOrUpdate(contact);
	        } catch (Exception e) {
	         message = new Contact();
	        }
	    return message;
	    } 
	
	@GetMapping("/contact")  
	private List<Contact> getAllContact()   
	{  
	return contactService.getAllContact();  
	}  
	
}
