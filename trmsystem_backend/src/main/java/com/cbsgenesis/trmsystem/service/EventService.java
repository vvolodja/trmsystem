package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Event;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Orange on 05.03.2017.
 */
public interface EventService {

    void save(Event event);

    Event getById(UUID id);

    Event findByEventName(String eventName);

    Collection<Event> getAll();

    void delete(Event event);
}
