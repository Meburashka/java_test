package ru.stqa.pft.addressbook;

public class LoginSystem {
  private final String username;
  private final String password;

  public LoginSystem(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
