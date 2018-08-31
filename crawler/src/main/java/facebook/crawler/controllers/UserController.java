package facebook.crawler.controllers;

import facebook.crawler.domain.User;
import facebook.crawler.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableJpaRepositories(basePackages = {"facebook.crawler.repositories"})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }
}
