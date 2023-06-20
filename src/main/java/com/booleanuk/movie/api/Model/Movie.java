package com.booleanuk.movie.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.time.LocalDate;
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


//    @ManyToMany(mappedBy = "movies")
//    @JsonIgnoreProperties("movies")
//    private List<Cast> cast;




    public Movie(){
        super();
    }

    public Movie(String title, String synopsis){
        super();
        this.setTitle(title);
        this.setSynopsis(synopsis);
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

//    public List<Cast> getCast() {
//        return cast;
//    }
//
//    public void setCast(List<Cast> cast) {
//        this.cast = cast;
//    }
}
