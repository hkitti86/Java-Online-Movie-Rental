package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
