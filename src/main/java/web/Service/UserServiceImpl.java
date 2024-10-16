package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.UserDaoList;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoList userDaoList;

    @Override
    public List<User> listUsers() {
        return userDaoList.listUsers();
    }

    @Override
    public List<User> listUsers(int count) {
        List<User> cars = userDaoList.listUsers();
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }

    @Override
    public int carSize() {
        return userDaoList.listUsers().size();
    }
}
