package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContractData("Екатерина1", "Алексеевна1", "Сорокина1", "Mebur", "Title", "BSS", "Москва, Нагорный проезд, дом 5", "222222", "9265554544", "333333", "333334", "k@mail.ru", "s@mail.ru", "a@mail.ru", "https://www.yandex.ru/", "1984", "Москва", "1222222", "Примечания"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
