package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CastRepository extends JpaRepository<Cast, Integer> {
    Optional<Cast> findById(int id);
}
