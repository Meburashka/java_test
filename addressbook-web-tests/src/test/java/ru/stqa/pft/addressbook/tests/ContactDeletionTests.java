package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContract();
  }
}
