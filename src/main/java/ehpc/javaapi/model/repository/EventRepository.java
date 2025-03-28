package ehpc.javaapi.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ehpc.javaapi.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findByUserId(Long userId);

    @Query("SELECT COUNT(e) FROM Event e WHERE e.user.id = :userId AND TYPE(e) = :eventType")
    long countByUserIdAndEventType(@Param("userId") Long userId, @Param("eventType") Class<?> eventType);

}
