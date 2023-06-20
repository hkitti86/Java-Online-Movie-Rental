package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Actor;
import com.booleanuk.movie.api.Model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastRepository extends JpaRepository<Cast, Integer> {
    List<Cast> findCastByMovieId(int movieId);

}
