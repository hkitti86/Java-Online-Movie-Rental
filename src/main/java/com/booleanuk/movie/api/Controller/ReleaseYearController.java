package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Classification;
import com.booleanuk.movie.api.Model.ReleaseYear;
import com.booleanuk.movie.api.Repository.ReleaseYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("release")
public class ReleaseYearController {

    @Autowired
    private ReleaseYearRepository releaseYearRepository;


    @GetMapping
    public List<ReleaseYear> getAllRelease(){
        return this.releaseYearRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReleaseYear> getReleaseYearById(@PathVariable int id){
        ReleaseYear releaseYear = null;
        releaseYear = this.releaseYearRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This release year is not in the system"));
        return ResponseEntity.ok(releaseYear);
    }

    @PostMapping
    public ResponseEntity<ReleaseYear> createReleaseYear(@RequestBody ReleaseYear releaseYear) {
        return new ResponseEntity<ReleaseYear>(this.releaseYearRepository.save(releaseYear), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReleaseYear> updateReleaseYearById(@PathVariable int id, @RequestBody ReleaseYear releaseYear) {
        ReleaseYear updateReleaseYear = this.releaseYearRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This release year is not in the system"));

        updateReleaseYear.setId(releaseYear.getId());
        updateReleaseYear.setReleaseYear(releaseYear.getReleaseYear());

        return new ResponseEntity<ReleaseYear>(this.releaseYearRepository.save(updateReleaseYear), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ReleaseYear> deleteReleaseYear(@PathVariable int id) {
        ReleaseYear releaseYearDelete = this.releaseYearRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This release year is not in the system"));
        this.releaseYearRepository.delete(releaseYearDelete);
        return ResponseEntity.ok(releaseYearDelete);
    }
}
