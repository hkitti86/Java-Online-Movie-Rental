package com.booleanuk.movie.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "basket_content")
public class BasketContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "basket_id")
    private int basketId;

    @Column(name = "movie_id")
    private int movieId;

    public BasketContent(){
        super();
    }

    public BasketContent(int basketId, int movieId){
        super();
        this.setBasketId(basketId);
        this.setMovieId(movieId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
