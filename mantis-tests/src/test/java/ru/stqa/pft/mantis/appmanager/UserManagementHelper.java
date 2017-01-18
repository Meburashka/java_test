package ru.stqa.pft.mantis.appmanager;

/**
 * Created by SorEA on 18.01.2017.
 */

public class UserManagementHelper extends HelperBase {

  public UserManagementHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }
}
