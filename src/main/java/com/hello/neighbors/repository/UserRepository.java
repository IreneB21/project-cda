package com.hello.neighbors.repository;

import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.UserGetForVisitorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    User findUserById(long id);

    @Query(value = "SELECT s.picture FROM Subscriber s WHERE s.picture IS NOT NULL ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<String> fetchRandomPictures();

    @Query("SELECT new com.hello.neighbors.entity.dto.UserGetForVisitorDto(" +
            "s.id, s.lastname, s.firstname, s.pseudonym, s.introduction, s.picture, s.registrationDate) " +
            "FROM Subscriber s WHERE s.id = :id")
    UserGetForVisitorDto getUserInfosForVisitor(@Param("id") long id);
}
