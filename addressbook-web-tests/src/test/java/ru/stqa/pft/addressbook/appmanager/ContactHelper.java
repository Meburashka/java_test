package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContractData;

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
    type(By.name("company"), contractData.getCompany());
    type(By.name("address"), contractData.getAddress());
    type(By.name("home"), contractData.getHome());
    type(By.name("mobile"), contractData.getMobile());
    type(By.name("work"), contractData.getWork());
    type(By.name("fax"), contractData.getFax());
    type(By.name("email"), contractData.getEmail());
    type(By.name("email2"), contractData.getEmail2());
    type(By.name("email3"), contractData.getEmail3());
    type(By.name("homepage"), contractData.getHomepage());
    comboBox(By.xpath("//div[@id='content']/form/select[1]//option[23]"));
    comboBox(By.xpath("//div[@id='content']/form/select[2]//option[11]"));
    type(By.name("byear"), contractData.getByear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contractData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contractData.getAddress2());
    type(By.name("phone2"), contractData.getPhone2());
    type(By.name("notes"), contractData.getNotes());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
}
