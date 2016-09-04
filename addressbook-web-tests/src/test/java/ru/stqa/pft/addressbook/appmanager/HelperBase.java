package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

/**
 * Created by SorEA on 31.08.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        WebElement element = wd.findElement(locator);
        element.clear();
        element.sendKeys(text);
      }
    }
  }

  protected void comboBox(By locator) {
    if (!wd.findElement(locator).isSelected()) {
      click(locator);
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}