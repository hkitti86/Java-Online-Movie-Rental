package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.ReleaseYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseYearRepository extends JpaRepository<ReleaseYear, Integer> {
}
