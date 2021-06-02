package com.example.CrudCheckpoint.repository;

import com.example.CrudCheckpoint.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

}
