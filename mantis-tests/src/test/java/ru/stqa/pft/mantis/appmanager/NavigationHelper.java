package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by SorEA on 18.01.2017.
 */

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void userManagementPage() {
    click(By.linkText("управление"));
    click(By.linkText("Управление пользователями"));
  }
}