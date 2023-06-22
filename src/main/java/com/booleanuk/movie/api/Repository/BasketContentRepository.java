package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.BasketContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketContentRepository extends JpaRepository<BasketContent, Integer> {
}
