package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    @Query("SELECT DISTINCT p FROM Publication p " +
            "LEFT JOIN FETCH p.author a " +
            "WHERE a.id = :authorId")
    List<Publication> findPublicationsWithAuthorByAuthorId(@Param("authorId") long authorId);

    @Query(value = """
        SELECT p.* FROM Publication p
        WHERE (6371 * acos(
            cos(radians(:lat)) * cos(radians(p.latitude)) *
            cos(radians(p.longitude) - radians(:lng)) +
            sin(radians(:lat)) * sin(radians(p.latitude))
        )) <= :radiusKm
        """, nativeQuery = true)
    List<Publication> findAllWithinRadius(@Param("lat") double lat,
                                          @Param("lng") double lng,
                                          @Param("radiusKm") double radiusKm);
}
