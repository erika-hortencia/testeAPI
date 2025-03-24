package ehpc.javaapi.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ehpc.javaapi.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findByUserId(Long userId);
}
