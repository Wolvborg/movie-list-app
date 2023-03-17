package org.wolb.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.wolb.movies.exception.InvalidEntryException;
import org.wolb.movies.model.Movie;
import org.wolb.movies.service.MovieService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping({ "", "/", "/all" })
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public String getMovieByIdParam(@RequestParam String id,
            @RequestParam(value = "p") String page) {
        return id + page;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String id) {
        if (id.matches("-?\\d+"))
            return new ResponseEntity<>(movieService.movieById(id), HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ID contained a non-numerical value.");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewMovie(@RequestBody Map<String, String> payload) {
        String title = payload.get("title");
        String imdbId = payload.get("imdbId");
        String releaseDate = payload.get("releaseDate");
        String trailerLink = payload.get("trailerLink");
        String poster = payload.get("poster");

        movieService.addMovie(new Movie(imdbId, title, releaseDate, trailerLink, poster));

        return new ResponseEntity<>("Movie " + title + " added", HttpStatus.CREATED);
    }

    @GetMapping("/testException")
    public void testInvalidEntryException() {
        throw new InvalidEntryException();
    }

}
