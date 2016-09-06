package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContract()) {
      app.getContactHelper().createContract(new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "test1"));
    }
    List<ContractData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContract();
    app.getNavigationHelper().returnToHomePage();
    List<ContractData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }
}