package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserService;
import web.model.User;

import java.util.List;

@Controller
public class UserController {

    private UserService userServiceImpl;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
//добавлять, удалять и изменять юзера.

    //	Все Юзеры
    @GetMapping(value = "/")
    public String getAllUser(Model model) {
        List<User> userList = userServiceImpl.listUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    // Выбрать юзера по ID
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "show";
    }

    //	Добавить Юзера
    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    //  Изменить Юзера
    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userServiceImpl.edit(user);
        return "redirect:/";
    }

    //   Удалить Юзера
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
        return "redirect:/";
    }
}
