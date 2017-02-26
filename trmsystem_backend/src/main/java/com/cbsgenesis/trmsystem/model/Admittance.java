package com.cbsgenesis.trmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents an Admittance.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "admittances")
public class Admittance extends NamedEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "admittances")
    private Set<Specialist> specialists;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

        Admittance that = (Admittance) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return specialists != null ? specialists.equals(that.specialists) : that.specialists == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (specialists != null ? specialists.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admittance{" +
                "description='" + description + '\'' +
                ", specialists=" + specialists +
                '}';
    }
}
