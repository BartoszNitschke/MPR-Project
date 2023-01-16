package com.mehtes.ProjectSpring.repository;

import com.mehtes.ProjectSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByPesel(String pesel);
}
