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
@RequestMapping("actors")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Actor> getAllActors() {
        return this.actorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createActor(@RequestBody Actor actor) {
        return new ResponseEntity<>(actorRepository.save(actor), HttpStatus.CREATED);
    }

}
