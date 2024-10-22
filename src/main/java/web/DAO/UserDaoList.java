package web.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDaoList extends JpaRepository<User, Integer> {

    public List<User> listUsers();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedPerson);

    public void delete(int id);
}
