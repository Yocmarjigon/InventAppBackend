package com.application.inventApp.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.application.inventApp.Entity.User;

public interface IUserService {
  List<User> findAll();

  Optional<User> findById(UUID id);

  public void saveUserIfNotExists(User user);

  void save(User user);

  Optional<User> update(UUID id, User user);

  Optional<User> deleate(UUID id);

}
