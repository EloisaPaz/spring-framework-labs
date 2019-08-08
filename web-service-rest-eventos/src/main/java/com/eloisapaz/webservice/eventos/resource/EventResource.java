package com.eloisapaz.webservice.eventos.resourse;

import com.eloisapaz.webservice.eventos.models.Event;
import com.eloisapaz.webservice.eventos.repository.EventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Events API REST")
@RestController
@RequestMapping("/event")
public class EventResource {

    @Autowired
    private EventRepository eventRepository;

    @ApiOperation(value = "Return event's list")
    @GetMapping(produces ="application/json")
    public @ResponseBody Iterable<Event> eventLis(){
        Iterable<Event> events = eventRepository.findAll();
        return events;
    }

    @ApiOperation(value = "Register an event")
    @PostMapping()
    public Event eventRegister(@RequestBody @Valid Event event){
        return eventRepository.save(event);
    }

    @ApiOperation(value = "Delete an event")
    @DeleteMapping()
    public Event deleteEvent(@RequestBody Event event){
        eventRepository.delete(event);
        return event;
    }
}
