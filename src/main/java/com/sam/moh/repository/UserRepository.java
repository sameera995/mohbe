package com.sam.moh.repository;


import com.sam.moh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
//
    Boolean existsByUsername(String username);
//
//    List<User> findByIdIn(List<Long> userIds);
//
    List<User> findAllByEmployeeIsNotNull();

}