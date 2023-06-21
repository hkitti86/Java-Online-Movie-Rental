package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "release")
public class ReleaseYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToMany(mappedBy = "releaseYear")
    @JsonIgnoreProperties("releaseYear")
    private List<Movie> movies;


    public ReleaseYear(){
        super();
    }

    public ReleaseYear(Integer releaseYear){
        super();
        this.setReleaseYear(releaseYear);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
