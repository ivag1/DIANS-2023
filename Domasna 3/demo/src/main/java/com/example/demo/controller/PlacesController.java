package com.example.demo.controller;

import com.example.demo.model.Place;
import com.example.demo.service.PlacesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/places")
@Validated
@CrossOrigin(origins = "*")
public class PlacesController {
    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

//    @GetMapping(value = "/all")
//    public ResponseEntity<List<Place>> getBasicView() {
//        return new ResponseEntity<>(placesService.findAllPlaces(), HttpStatus.OK);
//    }

    @GetMapping(value="/all")
    public String getMap(@RequestParam (name="text",required=false) String text, Model model){
        if(text==null||text.isEmpty()){
            model.addAttribute("places",placesService.findAllPlaces());
        }else {
            model.addAttribute("places", placesService.findByText(text));
        }
        return "map";
    }

}
