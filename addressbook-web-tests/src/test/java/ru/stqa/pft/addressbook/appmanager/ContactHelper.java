package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContractData;

/**
 * Created by SorEA on 31.08.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContractData contractData) {
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
}
