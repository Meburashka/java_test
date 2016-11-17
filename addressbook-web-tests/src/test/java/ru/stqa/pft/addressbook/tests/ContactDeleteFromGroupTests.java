package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SorEA on 17.11.2016.
 */
public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("name 1"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      ContactData contact = new ContactData()
              .withFirstName("Екатерина6").withMiddleName("Алексеевна").withLastName("Сорокина").withNickName("Mebur").withTitle("Title")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("k@k.ru").withEmail2("y@y.ru")
              .withEmail3("x@x.ru").withAddress("Москва, Нагорный проед 5");
      app.contact().create(contact);
      ContactData contactFromDB = app.db().contacts().iterator().next();
      GroupData group = app.db().groups().iterator().next();
      app.goTo().homePage();
      app.contact().selectContactById(contactFromDB.getId());
      app.contact().addingInGroupById(group.getId());
      app.goTo().homePageSelectedGroup(group.getId());

    } else {
      ContactData contact = app.db().contacts().iterator().next();
      GroupData group = app.db().groups().iterator().next();
      app.goTo().homePage();
      app.contact().selectContactById(contact.getId());
      app.contact().addingInGroupById(group.getId());
      app.goTo().homePageSelectedGroup(group.getId());
    }
  }

  @Test
  public void testContactAddingGroup() {

    Contacts contacts = app.db().contacts();
    Iterator<ContactData> iteratorContacts = contacts.iterator();
    ContactData contact = iteratorContacts.next();
    GroupData group = contact.getGroups().iterator().next();

    app.goTo().homePage();

    while (iteratorContacts.hasNext()) {
      if (contact.getGroups().size() > 0) {
        group = contact.getGroups().iterator().next();
        app.contact().filterGroupsById(group.getId());
        break;
      } else {
        contact = iteratorContacts.next();
      }
    }

    app.contact().selectContactById(contact.getId());
    app.contact().removeFromGroup();
    app.goTo().homePageSelectedGroup(group.getId());

    Groups groupsContactAfterAfter = app.db().contactById(contact.getId()).iterator().next().getGroups();

    assertThat(groupsContactAfterAfter, equalTo(
            contact.getGroups().withOut(group)));
  }
}