import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// This class contains unit tests to verify the functionality of the ContactService class
public class ContactServiceTest {
    private ContactService service;

    // This method runs before each test to initialize a fresh ContactService with one default contact
    @BeforeEach
    public void setup() {
        service = new ContactService();
        service.addContact(new Contact("001", "Alice", "Smith", "1234567890", "123 Main St"));
    }

    // Tests adding a new contact and verifying it was stored correctly
    @Test
    public void testAddContact() {
        Contact contact = new Contact("002", "Bob", "Jones", "0987654321", "456 Elm St");
        service.addContact(contact);
        assertEquals("Bob", service.getContact("002").getFirstName());
    }

    // Tests deleting an existing contact and confirming it's no longer retrievable
    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("001"));
    }

    // Tests updating a contact’s phone number and checking if the update was successful
    @Test
    public void testUpdatePhone() {
        service.updatePhone("001", "1112223333");
        assertEquals("1112223333", service.getContact("001").getPhone());
    }

    @Test
    public void testUpdateFirstName() {
    service.updateFirstName("001", "Mike");
    assertEquals("Mike", service.getContact("001").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
    service.updateLastName("001", "Johnson");
    assertEquals("Johnson", service.getContact("001").getLastName());
    }

    @Test
    public void testUpdateAddress() {
    service.updateAddress("001", "456 New Address");
    assertEquals("456 New Address", service.getContact("001").getAddress());
    }
}