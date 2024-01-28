package com.example.demo.controller;

import com.example.demo.model.Place;
import com.example.demo.model.User;
import com.example.demo.model.exceptions.PlaceNotFoundException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.service.PlacesService;
import com.example.demo.service.UsersService;
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
public class UsersController {

    private final UsersService usersService;
    private final PlacesService placesService;

    public UsersController(UsersService usersService, PlacesService placesService) {
        this.usersService = usersService;
        this.placesService = placesService;
    }

    @GetMapping("/users")
    public String addPlaceToFavourites(HttpServletRequest request, @RequestParam String placeName){
        try{
            User user = (User) request.getSession().getAttribute("user");
            Place place = this.placesService.findPlaceByName(placeName);
            System.out.println(place.getName());
            System.out.println(place.getPlaceId());
            System.out.println(user.getUsername());
            this.usersService.addPlaceToFavourites(user.getUsername(),place.getPlaceId());
            return "redirect:/places/all";
        }
        catch (Exception e){
            e.printStackTrace();
            return "redirect:/places/all";
        }
    }

}
