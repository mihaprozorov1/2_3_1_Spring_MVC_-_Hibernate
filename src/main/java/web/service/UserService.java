package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void save(User user);

    User getById(int id);

    void edit(User user);

    void delete(int id);
}
