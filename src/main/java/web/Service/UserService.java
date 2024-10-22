package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findOne(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(int id);
}
