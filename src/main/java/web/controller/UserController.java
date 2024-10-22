package web.controller;

import jakarta.validation.Valid;
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
import web.DAO.UserDaoList;
import web.Service.UserService;
import web.Service.UserServiceImpl;
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

    //выводятся всех юзеров
    @GetMapping(value = "/")
    public String getAllUser(Model model) {
        List<User> userList = userServiceImpl.listUsers();
        model.addAttribute("users", userList);
        return "users";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userDaoList.show(id));
//        return "show";
//    }
//    //добавляем нового юзера.
//    @GetMapping(value = "/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "new";
//        }
//        userDaoList.save(user);
//        return "redirect:/users";
//    }
//
//    //изменять юзера.
//    @GetMapping(value = "/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userDaoList.show(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
//                         @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }
//        userDaoList.update(id, user);
//        return "redirect:/users";
//    }
//
//    //удалять юзера.
//    @DeleteMapping(value = "/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userDaoList.delete(id);
//        return "redirect:/users";
//    }
}
