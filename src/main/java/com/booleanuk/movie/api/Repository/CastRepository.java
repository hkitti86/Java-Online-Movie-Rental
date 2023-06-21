package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CastRepository extends JpaRepository<Cast, Integer> {
    List<Cast> findByMovieId(int movieId);
    @Query("SELECT c.actor.name FROM Cast c WHERE c.movieId = :movieId")
    List<String> findActorNamesByMovieId(int movieId);
}
