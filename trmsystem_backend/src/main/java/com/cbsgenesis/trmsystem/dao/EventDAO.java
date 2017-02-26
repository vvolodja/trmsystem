package com.cbsgenesis.trmsystem.dao;


import com.cbsgenesis.trmsystem.model.Event;

import java.util.UUID;

/**
 * Extension of {@link GenericDAO} interface for {@link Event} class.
 *
 * @author Eugene Suleimanov
 */

public interface EventDAO extends GenericDAO<Event, UUID> {
}
