package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstName("Екатерина6").withMiddleName("Алексеевна").withLastName("Сорокина").withNickName("Mebur").withTitle("Title")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("k@k.ru").withEmail2("y@y.ru")
              .withEmail3("x@x.ru").withAddress("Москва, Нагорный проед 5")/*.withGroup("test2")*/);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstName("Екатерина7").withMiddleName("Алексеевна7").withLastName("Сорокина7").withNickName("Mebur7").withTitle("Title7")
            .withHomePhone("7111").withMobilePhone("7222").withWorkPhone("7333").withEmail("k7@k.ru").withEmail2("y7@y.ru")
            .withEmail3("x7@x.ru").withAddress("Москва, Нагорный проед 7");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
