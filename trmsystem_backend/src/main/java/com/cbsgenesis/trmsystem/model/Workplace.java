package com.cbsgenesis.trmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Workplace.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "workplaces")
public class Workplace extends NamedEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "workplaces")
    private Set<Event> events;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Workplace workplace = (Workplace) o;

        if (description != null ? !description.equals(workplace.description) : workplace.description != null)
            return false;
        return events != null ? events.equals(workplace.events) : workplace.events == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workplace{" +
                "description='" + description + '\'' +
                ", events=" + events +
                '}';
    }
}
