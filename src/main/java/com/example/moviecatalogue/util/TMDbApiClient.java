package com.example.moviecatalogue.util;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@Component
public class TMDbApiClient {

    private final String API_KEY = "931c36d3c86fab668959fdecb8ac6618";  // Make sure this is valid
    private final String BASE_URL = "https://api.themoviedb.org/3";
    private final RestTemplate restTemplate;

    public TMDbApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> fetchTrendingMovies() {
        String url = BASE_URL + "/trending/movie/week?api_key=" + API_KEY;

        try {
            System.out.println("Making API request to: " + url);  // Log the request URL
            ResponseEntity<MovieResponse> response = restTemplate.getForEntity(url, MovieResponse.class);

            if (response.getBody() != null && response.getBody().getResults() != null && !response.getBody().getResults().isEmpty()) {
                System.out.println("Received " + response.getBody().getResults().size() + " trending movies.");
                return response.getBody().getResults();
            } else {
                System.out.println("No trending movies found in the API response.");
            }
        } catch (Exception e) {
            System.out.println("Error fetching movies: " + e.getMessage());
            e.printStackTrace();
        }

        return Collections.emptyList();  // Return an empty list if something goes wrong
    }

    public Movie fetchMovieDetails(Long movieId) {
        String url = BASE_URL + "/movie/" + movieId + "?api_key=" + API_KEY;

        try {
            ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error fetching movie details: " + e.getMessage());
            e.printStackTrace();
        }
        return null;  // Return null if fetching details fails
    }
}
