package Test;

import src.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private static final String VALID_CONTACT_ID = "12345";
    private static final String VALID_FIRST_NAME = "John";
    private static final String VALID_LAST_NAME = "Doe";
    private static final String VALID_PHONE = "1234567890";
    private static final String VALID_ADDRESS = "123 Main St";
    
    private static final String LONG_CONTACT_ID = "12345678901"; 
    private static final String LONG_FIRST_NAME = "VeryLongName"; 
    private static final String LONG_LAST_NAME = "VeryLongLastName";
    private static final String SHORT_PHONE = "123456789"; 
    private static final String LONG_PHONE = "12345678901";
    private static final String LONG_ADDRESS = "This is a very long address that exceeds thirty characters"; 

    @Test
    void testContactCreation_withValidData_contactCreated() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_CONTACT_ID, contact.getContactId());
    }

    @Test
    void testContactCreation_withNullContactId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withLongContactId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(LONG_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withValidFirstName_firstNameSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_FIRST_NAME, contact.getFirstName());
    }


    @Test
    void testContactCreation_withNullFirstName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, null, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withLongFirstName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, LONG_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testSetFirstName_withValidName_firstNameUpdated() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newFirstName = "Jane";
        contact.setFirstName(newFirstName);
        assertEquals(newFirstName, contact.getFirstName());
    }

    @Test
    void testSetFirstName_withNullName_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    void testSetFirstName_withLongName_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
                assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(LONG_FIRST_NAME);
        });
    }

    @Test
    void testContactCreation_withValidLastName_lastNameSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_LAST_NAME, contact.getLastName());
    }

    @Test
    void testContactCreation_withNullLastName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, null, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withLongLastName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, LONG_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testSetLastName_withValidName_lastNameUpdated() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newLastName = "Smith";
        contact.setLastName(newLastName);
        assertEquals(newLastName, contact.getLastName());
    }

    @Test
    void testSetLastName_withNullName_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    void testSetLastName_withLongName_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(LONG_LAST_NAME);
        });
    }

    @Test
    void testContactCreation_withValidPhone_phoneSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_PHONE, contact.getPhone());
    }

    @Test
    void testContactCreation_withNullPhone_throwsIllegalArgumentException() {
         assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, null, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withShortPhone_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, SHORT_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withLongPhone_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, LONG_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    void testSetPhone_withValidPhone_phoneUpdated() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newPhone = "9876543210";
        contact.setPhone(newPhone);
        assertEquals(newPhone, contact.getPhone());
    }

    @Test
    void testSetPhone_withNullPhone_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    void testSetPhone_withInvalidLength_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(SHORT_PHONE);
        });
    }

    @Test
    void testContactCreation_withValidAddress_addressSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_ADDRESS, contact.getAddress());
    }

    @Test
    void testContactCreation_withNullAddress_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, null);
        });
    }

    @Test
    void testContactCreation_withLongAddress_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, LONG_ADDRESS);
        });
    }

    @Test
    void testSetAddress_withValidAddress_addressUpdated() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newAddress = "456 Oak Ave";
        contact.setAddress(newAddress);
        assertEquals(newAddress, contact.getAddress());
    }

    @Test
    void testSetAddress_withNullAddress_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    void testSetAddress_withLongAddress_throwsIllegalArgumentException() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(LONG_ADDRESS);
        });
    }

    @Test
    void testEquals_withSameContact_returnsTrue() {
        Contact contact1 = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        Contact contact2 = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertTrue(contact1.equals(contact2));
    }
   @Test
    void testContactCreation_withValidContactId_contactIdIsSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_CONTACT_ID, contact.getContactId());
    }

    @Test
    void testContactCreation_withValidLastName_lastNameIsSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_LAST_NAME, contact.getLastName());
    }

    @Test
    void testContactCreation_withNonDigitPhone_throwsIllegalArgumentException() {
        String invalidPhone = "12345abcde";
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, invalidPhone, VALID_ADDRESS);
        });
    }

    @Test
    void testContactCreation_withValidAddress_addressIsSet() {
        Contact contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_ADDRESS, contact.getAddress());
    }

    @Test
    void testEquals_withSameContactData_returnsTrue() {
        Contact contact1 = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        Contact contact2 = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        boolean result = contact1.equals(contact2);
        assertTrue(result);
    }
    
}