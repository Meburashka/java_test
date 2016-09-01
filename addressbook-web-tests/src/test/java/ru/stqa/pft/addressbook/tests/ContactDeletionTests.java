package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "BSS",
              "Москва, Нагорный проезд, дом 5", "222222", "9265554544", "333333", "333334", "k@mail.ru", "s@mail.ru",
              "a@mail.ru", "https://www.yandex.ru/", "1984", "test1", "Москва", "1222222", "Примечания"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContract();
  }
}