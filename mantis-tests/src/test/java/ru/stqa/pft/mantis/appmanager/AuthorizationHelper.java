package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by SorEA on 18.01.2017.
 */
public class AuthorizationHelper extends HelperBase {

  public AuthorizationHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void authorization(String login, String password) {
    type(By.cssSelector("#username"), login);
    type(By.cssSelector("#password"), password);
    click(By.cssSelector("input.button"));
  }
}