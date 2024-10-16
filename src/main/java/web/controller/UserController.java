package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.UserDaoList;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDaoList userDaoList;

    //выводятся всех юзеров
    @GetMapping(value = "")
    public String getAllUser(Model model) {
        model.addAttribute("users", userDaoList.listUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoList.show(id));
        return "show";
    }
    //добавлять нового юзера.
    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDaoList.save(user);
        return "redirect:/users";
    }

    //изменять юзера.
    @GetMapping(value = "/{id}/updateUser")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoList.show(id));
        return "updateUser";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDaoList.update(id, user);
        return "redirect:/users";
    }

    //удалять юзера.
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDaoList.delete(id);
        return "redirect:/users";
    }
}
