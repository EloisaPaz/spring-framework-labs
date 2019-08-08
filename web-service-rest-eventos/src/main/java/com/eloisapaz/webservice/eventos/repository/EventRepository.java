package com.eloisapaz.webservice.eventos.repository;

import com.eloisapaz.webservice.eventos.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
