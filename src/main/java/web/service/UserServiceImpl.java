package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoImpl;

    @Override
    public List<User> listUsers() {
        return userDaoImpl.listUsers();
    }

    @Override
    public List<User> listUsers(int count) {
        List<User> cars = userDaoImpl.listUsers();
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }

    @Transactional
    @Override
    public void save(User user) {
        userDaoImpl.save(user);
    }

    @Override
    public User getById(int id) {
        return userDaoImpl.getById(id);
    }

    @Override
    public void edit(User user) {
        userDaoImpl.update(user);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }
}
