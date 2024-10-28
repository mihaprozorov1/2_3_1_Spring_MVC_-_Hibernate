package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User getById(int id);

    void save(User user);

    void update(User updatedUser);

    void delete(int id);
}
