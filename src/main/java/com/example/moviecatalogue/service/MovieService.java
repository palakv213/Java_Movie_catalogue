package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;
import com.example.moviecatalogue.model.Favorite;
import com.example.moviecatalogue.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class MovieService {

    private final String TMDB_API_KEY = "931c36d3c86fab668959fdecb8ac6618";
    private final String TMDB_API_URL = "https://api.themoviedb.org/3/";

    private final RestTemplate restTemplate;
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public MovieService(RestTemplate restTemplate, FavoriteRepository favoriteRepository) {
        this.restTemplate = restTemplate;
        this.favoriteRepository = favoriteRepository;
    }

    public Movie getMovieById(Long id) {
        String url = TMDB_API_URL + "movie/" + id + "?api_key=" + TMDB_API_KEY;
        return restTemplate.getForObject(url, Movie.class);
    }

    public List<Movie> getTrendingMovies() {
        String url = TMDB_API_URL + "trending/movie/day?api_key=" + TMDB_API_KEY;
        MovieResponse response = restTemplate.getForObject(url, MovieResponse.class);
        return response != null ? response.getResults() : null;
    }

    public void addToFavorites(Long movieId) {
        Favorite favorite = new Favorite();
        favorite.setMovieId(movieId);
        favoriteRepository.save(favorite); // ✅ Correct: using the injected instance
    }

    // Get all favorites
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    // Get full Movie objects for the saved favorite movie IDs
    public List<Movie> getFavoriteMovieDetails(List<Favorite> favorites) {
        return favorites.stream()
                .map(fav -> getMovieById(fav.getMovieId()))
                .collect(Collectors.toList());
    }
}
