package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Classification;
import com.booleanuk.movie.api.Model.Movie;
import com.booleanuk.movie.api.Repository.MovieRepository;
import com.booleanuk.movie.api.Repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ClassificationRepository classificationRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        int classificationId = movie.getClassificationId();
        movie.setClassification(getClassificationById(classificationId));
        return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable int id, @RequestBody Movie movie) {
        Movie movieUpdate = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));

        movieUpdate.setTitle(movie.getTitle());
        movieUpdate.setSynopsis(movie.getSynopsis());
        movieUpdate.setReleaseYear(movie.getReleaseYear());

        int classificationId = movie.getClassificationId();
        movieUpdate.setClassification(getClassificationById(classificationId));

        return new ResponseEntity<>(movieRepository.save(movieUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
        Movie movieDelete = movieRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));

        movieRepository.delete(movieDelete);
        return ResponseEntity.ok(movieDelete);
    }

    private Classification getClassificationById(int id) {
        return classificationRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This classification is not in the system"));
    }
}

