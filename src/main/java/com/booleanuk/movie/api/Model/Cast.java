package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie_cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie")
    private Movie movie;

    @Column(name = "actor")
    private Actor actor;

    @ManyToMany(mappedBy = "movie_cast")
    @JsonIgnoreProperties("movie_cast")
    private List<Movie> movies;

    @ManyToMany(mappedBy = "movie_cast")
    @JsonIgnoreProperties("movie_cast")
    private List<Actor> actors;

    public Cast(){
        super();
    }

    public Cast(Movie movie, Actor actor){
        this.setMovie(movie);
        this.setActor(actor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Actor> getActors() {return actors;}

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
