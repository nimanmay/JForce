package com.example.service;
import java.util.List;

	@Service
	public class EventService {

	    @Autowired
	    private EventRepository eventRepository;

	    public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }

	    public Event saveEvent(Event event) {
	        return eventRepository.save(event);
	    }
	}
	
