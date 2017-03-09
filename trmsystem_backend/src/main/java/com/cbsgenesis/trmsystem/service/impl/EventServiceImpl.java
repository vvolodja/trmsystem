package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.EventDAO;
import com.cbsgenesis.trmsystem.model.Event;
import com.cbsgenesis.trmsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Orange on 05.03.2017.
 */

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventDAO eventDAO;

    @Override
    @Transactional
    public void save(Event event) {
        eventDAO.save(event);
    }

    @Override
    @Transactional
    public Event getById(UUID id) {
        return eventDAO.getById(id);
    }

    @Override
    @Transactional
    public Event findByEventName(String eventName) {
        return eventDAO.findByName(eventName);
    }

    @Override
    @Transactional
    public Collection<Event> getAll() {
        return eventDAO.getAll();
    }

    @Override
    @Transactional
    public void delete(Event event) {
        eventDAO.delete(event);
    }
}
