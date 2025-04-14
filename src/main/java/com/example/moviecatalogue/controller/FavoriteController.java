package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.moviecatalogue.service.MovieService;

//@Controller
//@RequestMapping("/favorites")
//public class FavoriteController {
//
//    @Autowired
//    private FavoriteService favoriteService;
//
//    @PostMapping("/add")
//    public String addFavorite(@RequestParam("movieId") Long movieId) {
//        favoriteService.addFavorite(movieId);
//        return "redirect:/";
//    }
//
//    @GetMapping
//    public String listFavorites(Model model) {
//        model.addAttribute("favorites", favoriteService.getAllFavorites());
//        return "favorites";
//    }
//
////    @GetMapping("/add-to-favorites/{id}")
////    public String addToFavorites(@PathVariable("id") Long movieId) {
////        MovieService.addToFavorites(movieId);
////        return "redirect:/movies"; // Redirects back to the movie list
////    }
//
//}
