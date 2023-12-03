package com.example.demo.controller;

import com.example.demo.model.Place;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
@Validated
@CrossOrigin(origins = "*")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/login")
    public String getLogInPage() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping(value = "/userMap")
    public String getUserMap(Model model) {
        //todo get info for user, not implemented
        return "userMap";
    }

}
