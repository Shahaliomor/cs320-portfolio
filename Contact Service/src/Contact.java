package src;

import java.util.Objects;

public class Contact {
    
    private static final int CONTACT_ID_MAX_LENGTH = 10;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int PHONE_LENGTH = 10;
    private static final int ADDRESS_MAX_LENGTH = 30;

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > CONTACT_ID_MAX_LENGTH) {
            throw new IllegalArgumentException("Contact ID must not be null and cannot exceed " + CONTACT_ID_MAX_LENGTH + " characters");
        }
        this.contactId = contactId;
        
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() { 
        return contactId; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }

    public String getPhone() { 
        return phone; 
    }

    public String getAddress() { 
        return address; 
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("First name should not be null and cannot exceed " + NAME_MAX_LENGTH + " characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Last name should  not be null and cannot exceed " + NAME_MAX_LENGTH + " characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != PHONE_LENGTH || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone should  be exactly " + PHONE_LENGTH + " digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > ADDRESS_MAX_LENGTH) {
            throw new IllegalArgumentException("Address should not be null and cannot exceed " + ADDRESS_MAX_LENGTH + " characters");
        }
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) obj;
        return Objects.equals(contactId, other.contactId) &&
               Objects.equals(firstName, other.firstName) &&
               Objects.equals(lastName, other.lastName) &&
               Objects.equals(phone, other.phone) &&
               Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, phone, address);
    }
}
