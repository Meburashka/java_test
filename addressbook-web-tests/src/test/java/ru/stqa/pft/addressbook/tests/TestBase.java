package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContractData;

/**
 * Created by SorEA on 05.08.2016.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  protected void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
  }

  protected void submitContactCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void fillContactForm(ContractData contractData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contractData.getFirstname());
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contractData.getMiddlename());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contractData.getLastname());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contractData.getNickname());
      wd.findElement(By.name("title")).click();
      wd.findElement(By.name("title")).clear();
      wd.findElement(By.name("title")).sendKeys(contractData.getTitle());
      wd.findElement(By.name("company")).click();
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(contractData.getCompany());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contractData.getAddress());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contractData.getHome());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contractData.getMobile());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(contractData.getWork());
      wd.findElement(By.name("fax")).click();
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(contractData.getFax());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contractData.getEmail());
      wd.findElement(By.name("email2")).click();
      wd.findElement(By.name("email2")).clear();
      wd.findElement(By.name("email2")).sendKeys(contractData.getEmail2());
      wd.findElement(By.name("email3")).click();
      wd.findElement(By.name("email3")).clear();
      wd.findElement(By.name("email3")).sendKeys(contractData.getEmail3());
      wd.findElement(By.name("homepage")).click();
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(contractData.getHomepage());
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[23]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[23]")).click();
      }
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[11]")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[11]")).click();
      }
      wd.findElement(By.name("byear")).click();
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys(contractData.getByear());
      wd.findElement(By.name("address2")).click();
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(contractData.getAddress2());
      wd.findElement(By.name("phone2")).click();
      wd.findElement(By.name("phone2")).clear();
      wd.findElement(By.name("phone2")).sendKeys(contractData.getPhone2());
      wd.findElement(By.name("notes")).click();
      wd.findElement(By.name("notes")).clear();
      wd.findElement(By.name("notes")).sendKeys(contractData.getNotes());
  }

  protected void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  @AfterMethod
  public void tearDown() {
      wd.quit();
  }
}