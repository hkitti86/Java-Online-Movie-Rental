package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Movie;
import com.booleanuk.movie.api.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movie = null;
        movie = this.movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<Movie>(this.movieRepository.save(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable int id, @RequestBody Movie movie) {
        Movie movieUpdate = this.movieRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));

        movieUpdate.setId(movie.getId());
        movieUpdate.setTitle(movieUpdate.getTitle());
        movieUpdate.setSynopsis(movieUpdate.getSynopsis());

        return new ResponseEntity<Movie>(this.movieRepository.save(movieUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
        Movie movieDelete = this.movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This movie is not in the system"));
        this.movieRepository.delete(movieDelete);
        return ResponseEntity.ok(movieDelete);
    }
}
