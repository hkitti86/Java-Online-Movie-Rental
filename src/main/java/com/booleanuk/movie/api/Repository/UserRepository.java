package com.booleanuk.movie.api.Repository;

import com.booleanuk.movie.api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
