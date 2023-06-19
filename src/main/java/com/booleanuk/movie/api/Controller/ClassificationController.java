package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.Classification;
import com.booleanuk.movie.api.Repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("classifications")
public class ClassificationController {

    @Autowired
    private ClassificationRepository classificationRepository;


    @GetMapping
    public List<Classification> getAllClassifications(){
        return this.classificationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classification> getClassificationById(@PathVariable int id){
        Classification classification = null;
        classification = this.classificationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This classification is not in the system"));
        return ResponseEntity.ok(classification);
    }

    @PostMapping
    public ResponseEntity<Classification> createClassification(@RequestBody Classification classification) {
        return new ResponseEntity<Classification>(this.classificationRepository.save(classification), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classification> updateClassificationById(@PathVariable int id, @RequestBody Classification classification) {
        Classification updateClassification = this.classificationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This classification is not in the system"));

        updateClassification.setId(classification.getId());
        updateClassification.setDescription(classification.getDescription());

        return new ResponseEntity<Classification>(this.classificationRepository.save(updateClassification), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classification> deleteClassification(@PathVariable int id) {
        Classification classificationDelete = this.classificationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This classification is not in the system"));
        this.classificationRepository.delete(classificationDelete);
        return ResponseEntity.ok(classificationDelete);
    }
}