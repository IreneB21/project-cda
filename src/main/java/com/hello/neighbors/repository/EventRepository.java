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
        SELECT e.* FROM Event e
        WHERE (6371 * acos(
            cos(radians(:lat)) * cos(radians(e.latitude)) *
            cos(radians(e.longitude) - radians(:lng)) +
            sin(radians(:lat)) * sin(radians(e.latitude))
        )) <= :radiusKm
        """, nativeQuery = true)
    List<Event> findAllWithinRadius(@Param("lat") double lat,
                                    @Param("lng") double lng,
                                    @Param("radiusKm") double radiusKm);

    @Query(value = """
        SELECT e.* FROM Event e
        WHERE (6371 * acos(
            cos(radians(:lat)) * cos(radians(e.latitude)) *
            cos(radians(e.longitude) - radians(:lng)) +
            sin(radians(:lat)) * sin(radians(e.latitude))
        )) <= :radiusKm
        AND e.start_date >= CURRENT_DATE
        ORDER BY e.start_date ASC
        LIMIT 3
        """, nativeQuery = true)
    List<Event> findNext3EventsWithinRadius(@Param("lat") double lat,
                                            @Param("lng") double lng,
                                            @Param("radiusKm") double radiusKm);
}
