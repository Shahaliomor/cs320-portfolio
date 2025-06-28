package src;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactService {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID must be unique");
            }
        }
        
        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        boolean removed = contacts.removeIf(contact -> contact.getContactId().equals(contactId));
        if (!removed) {
            throw new NoSuchElementException("Contact not found");
        }
    }

    public void updateFirstName(String contactId, String firstName) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setFirstName(firstName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateLastName(String contactId, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setLastName(lastName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updatePhone(String contactId, String phone) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setPhone(phone);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateAddress(String contactId, String address) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setAddress(address);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                // Return a new instance to prevent external modification
                return new Contact(
                    contact.getContactId(),
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getPhone(),
                    contact.getAddress()
                );
            }
        }
        return null;
    }

    public void updateContact(Contact updatedContact) {
        if (updatedContact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(updatedContact.getContactId())) {
                contacts.set(i, updatedContact);
                found = true;
                break;
            }
        }
        
        if (!found) {
            throw new NoSuchElementException("Contact not found");
        }
    }
}
