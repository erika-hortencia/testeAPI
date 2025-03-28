package ehpc.javaapi.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ehpc.javaapi.model.Event;
import ehpc.javaapi.model.User;
import ehpc.javaapi.model.repository.EventRepository;
import ehpc.javaapi.model.repository.UserRepository;
import ehpc.javaapi.service.EventService;
import jakarta.transaction.Transactional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Event> findEvents(Long userId) {
        return eventRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Event createEvent(Event eventToCreate, Long userID) {
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));

        eventToCreate.setUser(user);

        Class<?> eventClass = eventToCreate.getClass();
        long count = eventRepository.countByUserIdAndEventType(userID, eventClass);
        
        eventToCreate.setEventNumber((int) count + 1);

        return  eventRepository.save(eventToCreate);
    }
}
