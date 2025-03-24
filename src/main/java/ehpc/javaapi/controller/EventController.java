package ehpc.javaapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ehpc.javaapi.model.Event;
import ehpc.javaapi.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> findByUserId(@PathVariable Long userId){
        var events = eventService.findEvents(userId);

        return ResponseEntity.ok(events);

    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event eventToCreate, @RequestParam Long userId){
        var eventCreated = eventService.createEvent(eventToCreate, userId);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(eventCreated.getId())
            .toUri();

        return ResponseEntity.created(location).body(eventCreated);

    }

}
