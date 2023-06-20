package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Cast;
import com.booleanuk.movie.api.Repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casts")
public class CastController {

    @Autowired
    private CastRepository castRepository;


    @GetMapping
    public List<Cast> getAllCast() {
        return this.castRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cast> getCastById(@PathVariable int id) {
        Optional<Cast> castOptional = castRepository.findById(id);

        if (castOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cast cast = castOptional.get();
        return ResponseEntity.ok(cast);
    }


}

