package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Favorite;
import com.example.moviecatalogue.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public void addFavorite(Long movieId) {
        Favorite favorite = new Favorite();
        favorite.setMovieId(movieId);
        favoriteRepository.save(favorite);
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }
}
