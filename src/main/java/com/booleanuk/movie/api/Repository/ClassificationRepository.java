package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
}
