package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContractData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContractData contractData, boolean creation) {
    type(By.name("firstname"), contractData.getFirstname());
    type(By.name("middlename"), contractData.getMiddlename());
    type(By.name("lastname"), contractData.getLastname());
    type(By.name("nickname"), contractData.getNickname());
    type(By.name("title"), contractData.getTitle());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contractData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContract() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void returnToHomePageContact() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void createContract(ContractData contract) {
    initContactCreation();
    fillContactForm(contract, true);
    submitContactCreation();
    returnToHomePageContact();
  }

  public boolean isThereAContract() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContractData> getContactList() {
    List<ContractData> contacts = new ArrayList<ContractData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = entry]"));
    for (WebElement element : elements) {
      String firstname = element.getText();
      ContractData contract = new ContractData(firstname, null, null, null, null, null);
      contacts.add(contract);
    }
    return contacts;
  }
}
