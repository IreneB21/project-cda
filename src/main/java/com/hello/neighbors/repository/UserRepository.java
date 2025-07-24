package com.hello.neighbors.repository;

import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.UserGetForVisitorDto;
import com.hello.neighbors.entity.dto.UserLocationInfoDto;
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

    @Query("SELECT s.latitude AS latitude, s.longitude AS longitude, s.isInCity AS isInCity FROM Subscriber s WHERE s.id = :userId")
    UserLocationInfoDto findLocationInfoById(@Param("userId") Long userId);

    @Query(value = """
    SELECT COUNT(*) FROM subscriber s
    WHERE s.id <> :currentUserId AND (
      6371 * acos(
        cos(radians(:lat)) * cos(radians(s.latitude)) *
        cos(radians(s.longitude) - radians(:lng)) +
        sin(radians(:lat)) * sin(radians(s.latitude))
      )
    ) <= :radiusKm
    """, nativeQuery = true)
    Long calculateTotalUsersWithinRadius(@Param("lat") double lat,
                                         @Param("lng") double lng,
                                         @Param("radiusKm") double radiusKm,
                                         @Param("currentUserId") long currentUserId);
}
