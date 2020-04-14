package de.nsasse.roboadvisor.contract.rest;

import de.nsasse.roboadvisor.contract.model.User;
import de.nsasse.roboadvisor.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract/")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/userprofile")
    public void postProfile(@RequestBody User user) {
        userService.create(user);
    }
}

