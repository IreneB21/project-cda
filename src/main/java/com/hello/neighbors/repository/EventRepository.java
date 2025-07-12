package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT DISTINCT e FROM Event e " +
            "LEFT JOIN FETCH e.author a " +
            "LEFT JOIN FETCH e.participants p " +
            "WHERE a.id = :authorId")
    List<Event> findEventsWithParticipantsAndAuthorByAuthorId(@Param("authorId") long authorId);

    @Query(value = """
        SELECT p.* FROM publication p
        WHERE (6371 * acos(
            cos(radians(:lat)) * cos(radians(p.latitude)) *
            cos(radians(p.longitude) - radians(:lng)) +
            sin(radians(:lat)) * sin(radians(p.latitude))
        )) <= :radiusKm
        """, nativeQuery = true)
    List<Event> findAllWithinRadius(@Param("lat") double lat,
                                          @Param("lng") double lng,
                                          @Param("radiusKm") double radiusKm);
}
