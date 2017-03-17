package com.cbsgenesis.trmsystem.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Status of {@link Specialist}.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "statuses")
public class Status extends NamedEntity {

    @OneToMany(mappedBy = "status")
    private Set<Specialist> specialists;

    public Set<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(Set<Specialist> specialists) {
        this.specialists = specialists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Status status = (Status) o;

        return specialists != null ? specialists.equals(status.specialists) : status.specialists == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (specialists != null ? specialists.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "specialists=" + specialists +
                '}';
    }
}
