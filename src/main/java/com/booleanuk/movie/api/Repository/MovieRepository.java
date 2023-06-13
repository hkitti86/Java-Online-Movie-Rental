package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
