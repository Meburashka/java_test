package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by SorEA on 13.09.2016.
 */
public class ContactCheckDetailsTests extends TestBase {

  @Test
  public void testContactCheckInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactCheckDetails = app.contact().checkDetails(contact);
    ContactData contactInfoFormEditForm = app.contact().getInfoFormEditForm(contact);

    assertThat(contactCheckDetails.getCheckDetails(), equalTo(mergeCheckDetails(contactInfoFormEditForm)));
  }

  private String mergeCheckDetails(ContactData contact) {
    if (!(contact.getHomePhone().equals(""))) {
      contact.withHomePhone("H: " + contact.getHomePhone());
    }
    if (!(contact.getMobilePhone().equals(""))) {
      contact.withMobilePhone("M: " + contact.getMobilePhone());
    }
    if (!(contact.getWorkPhone().equals(""))) {
      contact.withWorkPhone("W: " + contact.getWorkPhone());
    }
    if (!(contact.getEmail().equals(""))) {
      if ((contact.getEmail().length()) > 1) {
        String mail = contact.getEmail();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail(contact.getEmail() + " (www." + s + ")");
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail(contact.getEmail() + " (www." + s + ")");
        }
      }
    }
    if (!(contact.getEmail2().equals(""))) {
      if ((contact.getEmail2().length()) > 1) {
        String mail = contact.getEmail3();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail2(contact.getEmail2() + " (www." + s + ")");
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail2(contact.getEmail2() + " (www." + s + ")");
        }
      }
    }
    if (!(contact.getEmail3().equals(""))) {
      if ((contact.getEmail3().length()) > 1) {
        String mail = contact.getEmail3();
        if (!((mail.indexOf("@")) == -1)) {
          String s = mail.substring(mail.indexOf("@") + 1, mail.length());
          contact.withEmail3(contact.getEmail3() + " (www." + s + ")");
        } else {
          String s = mail.substring(1, mail.length());
          contact.withEmail3(contact.getEmail3() + " (www." + s + ")");
        }
      }
    }

    return Arrays.asList(contact.getFirstName() + " " + contact.getLastName(), contact.getAddress() + "\n"
            , contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone() + "\n"
            , contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}