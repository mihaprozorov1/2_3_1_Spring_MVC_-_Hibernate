package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDaoList {

    public List<User> listUsers();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedPerson);

    public void delete(int id);
}
