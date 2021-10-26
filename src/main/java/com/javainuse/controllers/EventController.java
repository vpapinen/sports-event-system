package com.javainuse.controllers;

import com.javainuse.exception.ResourceNotFoundException;
import com.javainuse.model.Event;
import com.javainuse.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EventController {

    private static Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/events")
    public Event createEvent(@Valid @RequestBody Event event) {
        LOGGER.info("received event");
        return eventRepository.save(event);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId) throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("event not found for this id :: " + eventId));
        return ResponseEntity.ok().body(event);
    }

    @GetMapping("/events")
    public List<Event> getAllStudents() {
        return eventRepository.findAll();
    }
}
