package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContractData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContract (new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "test1"));
        List<ContractData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}