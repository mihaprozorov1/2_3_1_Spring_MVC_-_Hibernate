package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDaoList;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDaoList userDaoList;

    @Autowired
    public UserServiceImpl(UserDaoList userDaoList) {
        this.userDaoList = userDaoList;
    }

    //вернуть весь список Юзеров
    @Override
    public List<User> findAll() {
        return userDaoList.listUsers();
    }

    @Override
    public User findOne(int id){
    Optional<User> foundUser = userDaoList.findById(id);
    return foundUser.orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDaoList.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User updateUser) {
        userDaoList.update(id, updateUser);
        userDaoList.save(updateUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDaoList.deleteById(id);
    }
}
