package com.cbsgenesis.trmsystem.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Team of {@link Specialist}s.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "teams")
public class Team extends NamedEntity {

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private Set<Specialist> specialists;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private User supervisor;

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

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

        Team team = (Team) o;

        if (description != null ? !description.equals(team.description) : team.description != null) return false;
        return specialists != null ? specialists.equals(team.specialists) : team.specialists == null;

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
        return "Team{" +
                "description='" + description + '\'' +
                ", specialists=" + specialists +
                '}';
    }
}
