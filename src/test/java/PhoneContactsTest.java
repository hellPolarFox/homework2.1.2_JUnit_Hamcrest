import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class PhoneContactsTest {

    private PhoneContacts phoneContacts;
    private Contact contact;
    private final List<Contact> list = new ArrayList<>();

    @BeforeEach
    void before() {
        phoneContacts = new PhoneContacts("test");
        contact = new Contact("a", "b", "1");
    }

    @Test
    void whenAddingNewGroupToMap() {
        String group = "test";
        phoneContacts.addGroupToMap(group);

        assertThat(phoneContacts.phoneBook, hasKey(group));
    }

    @Test
    void whenAddingNewContactToMap() {
        String group = "test";
        list.add(contact);

        phoneContacts.addGroupToMap(group);
        phoneContacts.addContactToPhoneBook(contact, group);

        assertThat(list, equalTo(phoneContacts.phoneBook.get(group)));
    }

    @Test
    void whenCreatingNewContactFromConsole() {
        String input = "name surname number";
        String[] parts = input.split(" ");

        assertThat(parts, arrayWithSize(3));

    }

}
