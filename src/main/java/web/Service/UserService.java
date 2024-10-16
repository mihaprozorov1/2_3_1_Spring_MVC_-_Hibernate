package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public List<User> listUsers(int count);

    public int carSize();
}
