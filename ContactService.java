import java.util.HashMap;
import java.util.Map;

// This class manages a collection of Contact objects and provides methods to add, delete, and update them.
public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();  // Stores contacts using contactId as the key

    // Adds a contact if the ID is unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact by ID if it exists
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contacts.remove(contactId);
    }

    // The following methods update individual fields of a contact by ID
    public void updateFirstName(String contactId, String newFirstName) {
        getContact(contactId).setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        getContact(contactId).setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        getContact(contactId).setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        getContact(contactId).setAddress(newAddress);
    }

    // Returns a Contact object by ID or throws an error if not found
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found.");
        }
        return contacts.get(contactId);
    }
}