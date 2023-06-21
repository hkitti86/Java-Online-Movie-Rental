package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Actor;
import com.booleanuk.movie.api.Model.Cast;
import com.booleanuk.movie.api.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CastRepository extends JpaRepository<Cast, Integer> {
    List<Cast> findByMovieId(int movieId);

    List<Actor> findActorByMovieId(int movie_id);
}
