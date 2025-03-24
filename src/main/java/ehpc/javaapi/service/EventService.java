package ehpc.javaapi.service;

import java.util.List;

import ehpc.javaapi.model.Event;

public interface EventService {
    
    List<Event> findEvents(Long userId);



    Event createEvent(Event eventToCreate, Long userID);
}
