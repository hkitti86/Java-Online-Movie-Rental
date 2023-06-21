package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "release_year")
    @JsonIgnoreProperties("movies")
    private ReleaseYear releaseYear;

    @ManyToOne
    @JoinColumn(name = "classification")
    @JsonIgnoreProperties({"movies", "classification"})
    private Classification classification;

    public Movie(){
        super();
    }

    public Movie(String title, String synopsis){
        super();
        this.title = title;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @JsonIgnore
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;

    }
    public String getClassificationDescription() {
        if (classification != null) {
            return classification.getDescription();
        }
        return null;
    }

    @JsonIgnore
    public ReleaseYear getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(ReleaseYear releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getReleaseYearOfMovie() {
        if (releaseYear != null){
            return releaseYear.getReleaseYear();
        }
        return 0;
    }

}
