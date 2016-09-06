package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "BSS",
              "Москва, Нагорный проезд, дом 5", "222222", "9265554544", "333333", "333334", "k@mail.ru", "s@mail.ru",
              "a@mail.ru", "https://www.yandex.ru/", "1984", "test1", "Москва", "1222222", "Примечания"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContractData("Екатерина1", null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "Москва1", null, "Примечания1"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePageContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
