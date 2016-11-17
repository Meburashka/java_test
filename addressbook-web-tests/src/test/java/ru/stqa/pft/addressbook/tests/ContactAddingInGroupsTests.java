package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SorEA on 17.11.2016.
 */
public class ContactAddingInGroupsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstName("Екатерина6").withMiddleName("Алексеевна").withLastName("Сорокина").withNickName("Mebur").withTitle("Title")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("k@k.ru").withEmail2("y@y.ru")
              .withEmail3("x@x.ru").withAddress("Москва, Нагорный проед 5"));
    }
  }

  @Test
  public void testContactAddingGroup() {
    Groups groupsBefore = app.db().groups();
    Contacts contactsBefore = app.db().contacts();
    ContactData selectedContact = contactsBefore.iterator().next();
    Groups groupsSelectedContact = selectedContact.getGroups();
    GroupData selectedGroup;
    Iterator<ContactData> iteratorContacts = contactsBefore.iterator();

    while (iteratorContacts.hasNext()) {
      if (groupsSelectedContact.equals(groupsBefore)) {
        selectedContact = iteratorContacts.next();
        groupsSelectedContact = selectedContact.getGroups();
      } else {
        break;
      }
    }

    if (groupsSelectedContact.equals(groupsBefore)) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("name 1"));
    }
    groupsBefore = app.db().groups();
    groupsSelectedContact = selectedContact.getGroups();
    groupsBefore.removeAll(groupsSelectedContact);

    if (groupsBefore.size() > 0) {
      selectedGroup = groupsBefore.iterator().next();
    } else {
      throw new RuntimeException("Нет доступных групп");
    }

    app.goTo().homePage();
    app.contact().selectContactById(selectedContact.getId());
    app.contact().addingInGroupById(selectedGroup.getId());
    app.goTo().homePageSelectedGroup(selectedGroup.getId());

    ContactData contactAfter = app.db().contactById(selectedContact.getId()).iterator().next();
    Groups groupsContactAfter = contactAfter.getGroups();
    assertThat(groupsContactAfter, equalTo(
            groupsSelectedContact.withAdded(selectedGroup)));
  }
}