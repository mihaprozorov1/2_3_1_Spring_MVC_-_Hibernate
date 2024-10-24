package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> listUsers();

    public User getById(int id);

    public void save(User user);

    public void update(User updatedUser);

    public void delete(int id);
}
