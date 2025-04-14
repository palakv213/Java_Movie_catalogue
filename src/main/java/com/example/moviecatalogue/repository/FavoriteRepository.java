package com.example.moviecatalogue.repository;

import com.example.moviecatalogue.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByMovieId(Long movieId);  // Check if the movie exists in favorites
}
