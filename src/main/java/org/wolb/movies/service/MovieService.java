package org.wolb.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wolb.movies.repository.MovieRepository;
import org.wolb.movies.model.Movie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> movieById(String id){
        return movieRepository.findMovieByImdbId(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.insert(movie);
    }
}
