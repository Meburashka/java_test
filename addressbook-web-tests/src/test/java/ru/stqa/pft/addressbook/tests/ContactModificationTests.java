package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.List;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "test1"));
    }
    List<ContractData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContractData("Екатерина1", null, null, null, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePageContact();
    List<ContractData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
