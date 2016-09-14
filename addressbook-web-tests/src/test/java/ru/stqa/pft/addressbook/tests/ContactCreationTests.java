package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData().withFirstName("FirstName").withMiddleName("MiddleName").withLastName("LastName").withNickName("NickName").withGroup("test")});
        list.add(new Object[] {new ContactData().withFirstName("FirstName1").withMiddleName("MiddleName1").withLastName("LastName1").withNickName("NickName1").withGroup("test")});
        list.add(new Object[] {new ContactData().withFirstName("FirstName2").withMiddleName("MiddleName2").withLastName("LastName2").withNickName("NickName2").withGroup("test")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        //File photo = new File("src/test/resources/stru.jpg");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Екатерина6'").withMiddleName("Алексеевна").withLastName("Сорокина").withNickName("Mebur").withTitle("Title")
                .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withGroup("test");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}