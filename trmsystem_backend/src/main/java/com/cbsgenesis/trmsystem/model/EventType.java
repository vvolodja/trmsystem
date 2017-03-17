package com.cbsgenesis.trmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents Type of {@link Event} (workday, technical study, simulator, etc.)
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "event_types")
public class EventType extends NamedEntity {

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "eventType")
    private Set<Event> events;

}
