package com.booleanuk.movie.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    public Classification(){
        super();
    }

    public Classification(String description) {
        this.description = description;
    }

}
