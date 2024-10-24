package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public List<User> listUsers(int count);

    public void save(User user);

    public User getById(int id);

    public void edit(User user);

    public void delete(int id);
}
