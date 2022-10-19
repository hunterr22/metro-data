package com.metro.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.metro.domain.Events;
import com.metro.repository.EventsRepository;

@RestController
@RequestMapping("/events")
public class EventsAPI {

	@Autowired
	EventsRepository repo;

	@GetMapping
	public Iterable<Events> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{event_id}")
	public Optional<Events> getEventById(@PathVariable("event_id") long id) {
		return repo.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Events newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getCode() == null || newEvent.getTitle() == null
				|| newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build(); // Reject - we'll assign the event id
		}

		newEvent = repo.save(newEvent);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newEvent.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{event_id}")
	public ResponseEntity<?> putEvent(@RequestBody Events newEvent,
			@PathVariable("event_id") long event_id) {

		if (newEvent.getId() != event_id || newEvent.getCode() == null || newEvent.getTitle() == null
				|| newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}

		repo.save(newEvent);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{event_id}")
	public ResponseEntity<?> deleteEvent(@PathVariable("event_id") long id) {
		repo.deleteById(id); // can also delete by Events entity type, should we add another method?

		return ResponseEntity.noContent().build();
	}
}