package com.cbsgenesis.trmsystem.dao;

import com.cbsgenesis.trmsystem.model.Team;

import java.util.UUID;

/**
 * Extension of {@link GenericDAO} interface for {@link Team} class.
 *
 * @author Eugene Suleimanov
 */

public interface TeamDAO extends GenericDAO<Team, UUID> {
}
