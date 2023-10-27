package com.esprit.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public ContactModel save(ContactModel contact) {	return contactRepository.save(contact);
    }



    public List<ContactModel> findAll() {
        return contactRepository.findAll();
    }


    public ContactModel findById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }


    public ContactModel updateContact(ContactModel contact) {
        ContactModel existingContact = contactRepository.findById(contact.getId()).orElse(null);

        if (existingContact != null) {
            existingContact.setNom(contact.getNom());
            existingContact.setPrenom(contact.getPrenom());
            existingContact.setEmail(contact.getEmail());
            existingContact.setDatedenaissaince(contact.getDatedenaissaince());
            existingContact.setPoste(contact.getPoste());
            existingContact.setNotes(contact.getNotes());
            existingContact.setReseauxsociaux(contact.getReseauxsociaux());

            return contactRepository.save(existingContact);
        }

        return null;
    }

}
