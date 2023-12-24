package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@Validated
//@CrossOrigin(origins = "*")
public class UsersController {

}
