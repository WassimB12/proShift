package com.esprit.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    public List<ContactModel> getAllContacts() {
        return contactService.findAll();
    }

    @PostMapping
    public ResponseEntity<ContactModel> createContact(@RequestBody ContactModel contact ) {
        ContactModel savedContact = contactService.save(contact);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        contactService.deleteById(id);
        return ResponseEntity.ok("Contact with ID " + id + " deleted successfully.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<ContactModel> updateContact(@PathVariable int id, @RequestBody ContactModel contact) {
        contact.setId(id);
        ContactModel updatedContact = contactService.updateContact(contact);
        if (updatedContact != null) {
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<ContactModel> getCongeById(@PathVariable int id) {
        ContactModel contact = contactService.findById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
