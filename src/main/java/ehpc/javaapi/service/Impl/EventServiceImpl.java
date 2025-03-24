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

        return  eventRepository.save(eventToCreate);
    }

  /*   private final EventRepository eventRepository;

    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Event> findByUserId(Long userId) {
        return eventRepository.findById(userId);
    }

    @Override
    public Event cretEvent(Event eventToCreate) {
        if(eventRepository.existsById(eventToCreate.getId())){
            throw  new IllegalArgumentException("User ID already exists");

        }
        return eventRepository.save(eventToCreate);
    }

    @Override
    public Event cretEvent(Event eventToCreate, Long userID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cretEvent'");
    }
 */
}
