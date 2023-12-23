package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
@Validated
@CrossOrigin(origins = "*")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Model model,
                        HttpSession session){
//        model.addAttribute("hasError",false);
//        model.addAttribute("error","");
        try {
            User user = this.usersService.login(username, password);
            session.setAttribute("user",user);
            return "userMap";
        }
        catch (Exception e) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "userMap";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@RequestParam(value = "username") String username,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password,
                              HttpSession session)
    {
        User user = this.usersService.register(username,password,email);
        session.setAttribute("user",user);
        return "redirect:/users/login";
    }

}
