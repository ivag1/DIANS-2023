package com.example.demo.controller;


import com.example.demo.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           Model model) {
        try{
            this.authService.register(username, name, email, password, repeatPassword);
            return "redirect:/login";
        }
        catch (Exception e){
            model.addAttribute("hasError",true);
            model.addAttribute("error",e.getMessage());
            e.printStackTrace();
            return "register";
        }
    }
}
