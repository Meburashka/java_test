package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SorEA on 18.01.2017.
 */

public class Users extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public Users(Users Users) {
    this.delegate = new HashSet<UserData>(Users.delegate);
  }

  public Users() {
    this.delegate = new HashSet<UserData>();
  }

  public Users(Collection<UserData> Users) {
    this.delegate = new HashSet<UserData>(Users);
  }

  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }

  public Users withAdded(UserData contact) {
    Users Users = new Users(this);
    Users.add(contact);
    return Users;
  }

  public Users without(UserData contact) {
    Users Users = new Users(this);
    Users.remove(contact);
    return Users;
  }
}