package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContract (new ContractData("Екатерина", "Алексеевна", "Сорокина", "Mebur", "Title", "BSS",
                "Москва, Нагорный проезд, дом 5", "222222", "9265554544", "333333", "333334", "k@mail.ru", "s@mail.ru",
                "a@mail.ru", "https://www.yandex.ru/", "1984", "test1", "Москва", "1222222", "Примечания"), true);
    }
}