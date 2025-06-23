// This class represents a Contact with ID, name, phone number, and address.
// It includes validation to ensure each field meets specific length or format requirements.
public class Contact {
    private final String contactId;  // Unique and unchangeable contact ID
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor initializes a Contact object and performs validation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contactId");
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid firstName");
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid lastName");
        if (phone == null || phone.length() != 10)
            throw new IllegalArgumentException("Phone must be 10 digits");
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods for all contact fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setter methods include validation to maintain data integrity

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid firstName");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid lastName");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10)
            throw new IllegalArgumentException("Phone must be 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}