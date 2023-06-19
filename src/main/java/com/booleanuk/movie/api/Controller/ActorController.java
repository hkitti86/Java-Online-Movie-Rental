package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Actor;
import com.booleanuk.movie.api.Model.Movie;
import com.booleanuk.movie.api.Repository.ActorRepository;
import com.booleanuk.movie.api.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies/{id}/actors")
    public List<Actor> getAllActors(@PathVariable int id) {
        return this.actorRepository.findActorByMovieId(id);
    }

    @PostMapping("/actors")
    public ResponseEntity<List<Movie>> createActor(@RequestBody Actor actor) {
        List<Movie> movies = this.movieRepository.findAll();
        List<Movie> actorMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getActors().contains(actor)) {
                actorMovies.add(movie);
            }
        }

        return new ResponseEntity<>(actorMovies, HttpStatus.OK);
    }
}
