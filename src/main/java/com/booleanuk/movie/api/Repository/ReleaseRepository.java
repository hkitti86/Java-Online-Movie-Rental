package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {
}
