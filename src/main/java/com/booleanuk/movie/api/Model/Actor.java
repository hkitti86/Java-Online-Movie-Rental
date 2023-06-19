package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    private List<Movie> movies;



    public Actor (){
        super();
    }

    public Actor(int id) {
        super();
        this.id = id;
    }

    public Actor(String name){
        super();
        this.setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {return movies;}

    public void setMovies(List<Movie> movies) {this.movies = movies;}
}
