package Test;

import src.Contact;
import src.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact testContact;
    
    private static final String VALID_CONTACT_ID = "12345";
    private static final String VALID_FIRST_NAME = "John";
    private static final String VALID_LAST_NAME = "Doe";
    private static final String VALID_PHONE = "1234567890";
    private static final String VALID_ADDRESS = "123 Main St";
    
    private static final String DUPLICATE_CONTACT_ID = "12345";
    private static final String NONEXISTENT_CONTACT_ID = "99999";
    private static final String UPDATED_FIRST_NAME = "Jane";
    private static final String UPDATED_LAST_NAME = "Smith";
    private static final String UPDATED_PHONE = "9876543210";
    private static final String UPDATED_ADDRESS = "456 Oak Ave";

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        testContact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
    }
   
    @Test
    void testAddContact_withValidContact_shouldAddSuccessfully() {
        Contact contact = testContact;
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact(contact.getContactId());
        assertEquals(contact, retrievedContact);
    }

    @Test
    void testAddContact_withDuplicateId_shouldThrowException() {
        Contact contact1 = testContact;
        Contact contact2 = new Contact(DUPLICATE_CONTACT_ID, UPDATED_FIRST_NAME, UPDATED_LAST_NAME, UPDATED_PHONE, UPDATED_ADDRESS);
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    void testDeleteContact_withExistingId_shouldDeleteSuccessfully() {
        contactService.addContact(testContact);
        
        contactService.deleteContact(testContact.getContactId());
        assertNull(contactService.getContact(testContact.getContactId()));
    }

    @Test
    void testDeleteContact_withNonExistingId_shouldThrowException() { 
        assertThrows(NoSuchElementException.class, () -> contactService.deleteContact(NONEXISTENT_CONTACT_ID));
    }

    @Test
    void testUpdateContact_withValidContact_shouldUpdateSuccessfully() {
        contactService.addContact(testContact);
        Contact updatedContact = new Contact(
            testContact.getContactId(),
            UPDATED_FIRST_NAME,
            UPDATED_LAST_NAME,
            UPDATED_PHONE,
            UPDATED_ADDRESS
        );
        
        contactService.updateContact(updatedContact);
        Contact retrievedContact = contactService.getContact(testContact.getContactId());
        assertEquals(updatedContact, retrievedContact);
    }

    @Test
    void testUpdateContact_withNonExistingId_shouldThrowException() {
        Contact nonExistingContact = new Contact(NONEXISTENT_CONTACT_ID, UPDATED_FIRST_NAME, UPDATED_LAST_NAME, UPDATED_PHONE, UPDATED_ADDRESS);
        assertThrows(NoSuchElementException.class, () -> contactService.updateContact(nonExistingContact));
    }

    @Test
    void testGetContact_withExistingId_shouldReturnContact() {
        contactService.addContact(testContact);
        Contact retrievedContact = contactService.getContact(testContact.getContactId());
        assertEquals(testContact, retrievedContact);
    }

    @Test
    void testGetContact_withNonExistingId_shouldReturnNull() {
        Contact retrievedContact = contactService.getContact(NONEXISTENT_CONTACT_ID);
        assertNull(retrievedContact);
    }

    @Test
    void testGetContact_shouldReturnNewInstance() {
        contactService.addContact(testContact);
        Contact retrievedContact1 = contactService.getContact(testContact.getContactId());
        Contact retrievedContact2 = contactService.getContact(testContact.getContactId());
        assertNotSame(retrievedContact1, retrievedContact2);
        assertEquals(retrievedContact1, retrievedContact2);
    }
}
