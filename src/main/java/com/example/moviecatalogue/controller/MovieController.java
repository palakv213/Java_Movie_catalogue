package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.moviecatalogue.model.Favorite;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Show trending movies
    @GetMapping("/movies")
    public String showMovies(Model model) {
        List<Movie> trendingMovies = movieService.getTrendingMovies();
        model.addAttribute("movies", trendingMovies);
        return "movies"; // maps to movies.html
    }

    @GetMapping("/movies/{id}")
    public String viewMovieDetails(@PathVariable("id") Long movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie_details"; // make sure this HTML template exists
    }

    // Handle Add to Favorites
    @GetMapping("/add-to-favorites/{id}")
    public String addToFavorites(@PathVariable("id") Long movieId) {
        movieService.addToFavorites(movieId);
        return "redirect:/movies"; // after saving, go back to list
    }

    @GetMapping("/favorites")
    public String viewFavorites(Model model) {
        List<Favorite> favorites = movieService.getAllFavorites(); // Get movie IDs from DB
        List<Movie> favoriteMovies = movieService.getFavoriteMovieDetails(favorites); // Fetch full details
        model.addAttribute("favoriteMovies", favoriteMovies);
        return "favorites";
    }
}
