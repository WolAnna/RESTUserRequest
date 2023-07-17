package com.example.UserRequest.DB.repositories;

import com.example.UserRequest.DB.modelDB.UserRequestDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRequestRepository extends CrudRepository<UserRequestDB, Long> {
    @Query(nativeQuery = true, value= "SELECT * FROM users_requests WHERE login = :login ")
    UserRequestDB getUserByLogin(@Param("login") String login);
}