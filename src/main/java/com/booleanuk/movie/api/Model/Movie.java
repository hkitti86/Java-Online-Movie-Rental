package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "release_year")
    private String releaseYear;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("movie")
    private List<Cast> cast;


    @ManyToOne
    @JoinColumn(name = "classification")
    @JsonIgnoreProperties({"movies", "classification"})
    private Classification classification;

    public Movie(){
        super();
    }

    public Movie(String title, String synopsis, String releaseYear){
        super();
        this.setTitle(title);
        this.synopsis = synopsis;
        this.releaseYear = releaseYear;
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

    public List<String> getCastActorsNames() {
        if (cast != null && !cast.isEmpty()) {
            List<String> actorNames = new ArrayList<>();
            for (Cast castItem : cast) {
                actorNames.add(castItem.getActor().getName());
            }
            return actorNames;
        }
        return null;
    }

    @JsonIgnore
    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
