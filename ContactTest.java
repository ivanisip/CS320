import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// This class contains unit tests for the Contact class constructor and setter validations
public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
public void testContactIdCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    });
}

@Test
public void testFirstNameCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123", null, "Doe", "1234567890", "123 Main St");
    });
}

@Test
public void testLastNameCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123", "John", null, "1234567890", "123 Main St");
    });
}

@Test
public void testPhoneCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123", "John", "Doe", null, "123 Main St");
    });
}

@Test
public void testAddressTooLong() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123", "John", "Doe", "1234567890", "This address is way too long for the field limit to handle!");
    });
}

    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
    }

    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}