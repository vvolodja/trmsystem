package com.cbsgenesis.trmsystem.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents an Event (Workday, Technical study, etc.)
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "events")
public class Event extends NamedEntity {

    @Column(name = "event_date")
    private Date date;

    @ManyToMany
    @JoinTable(name = "event_workplaces", joinColumns = {@JoinColumn(name = "event_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "workplace_id", referencedColumnName = "id")})
    private Set<Workplace> workplaces;

    @ManyToMany(mappedBy = "events")
    private Set<Specialist> specialistsInvolved;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Event event = (Event) o;

        return date != null ? date.equals(event.date) : event.date == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                '}';
    }
}