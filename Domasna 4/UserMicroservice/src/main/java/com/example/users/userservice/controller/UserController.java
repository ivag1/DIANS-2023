package com.example.users.userservice.controller;

import com.example.users.userservice.model.User;
import com.example.users.userservice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@Validated
//@CrossOrigin(origins = "*")
public class UserController {

    private final UserService usersService;
    //private final PlacesService placesService;

    public UserController(UserService usersService) {
        this.usersService = usersService;
        //this.placesService = placesService;
    }

    @GetMapping("/users")
    public String addPlaceToFavourites(HttpServletRequest request, @RequestParam String placeName){
        try{
            User user = (User) request.getSession().getAttribute("user");
            //Place place = this.placesService.findPlaceByName(placeName);
            this.usersService.addPlaceToFavourites(user.getUsername(),placeName);
            return "redirect:/places/all";
        }
        catch (Exception e){
            e.printStackTrace();
            return "redirect:/places/all";
        }
    }

}
