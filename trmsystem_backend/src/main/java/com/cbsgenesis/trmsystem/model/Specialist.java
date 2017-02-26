package com.cbsgenesis.trmsystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Specialist.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "specialists")
public class Specialist extends BaseEntity {

    @Column(name = "personnel_number")
    private Integer personnelNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_specialties", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "specialty_id", referencedColumnName = "id")})
    private Set<Specialty> specialties;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "specialist_admittances", joinColumns = {@JoinColumn(name = "specialist_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "admittance_id", referencedColumnName = "id")})
    private Set<Admittance> admittances;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "specialist_events", joinColumns = {@JoinColumn(name = "specialist_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id", referencedColumnName = "id")})
    private Set<Event> events;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<Admittance> getAdmittances() {
        return admittances;
    }

    public void setAdmittances(Set<Admittance> admittances) {
        this.admittances = admittances;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Specialist that = (Specialist) o;

        if (personnelNumber != null ? !personnelNumber.equals(that.personnelNumber) : that.personnelNumber != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (specialties != null ? !specialties.equals(that.specialties) : that.specialties != null) return false;
        if (admittances != null ? !admittances.equals(that.admittances) : that.admittances != null) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (events != null ? !events.equals(that.events) : that.events != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (personnelNumber != null ? personnelNumber.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (specialties != null ? specialties.hashCode() : 0);
        result = 31 * result + (admittances != null ? admittances.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "personnelNumber=" + personnelNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", specialties=" + specialties +
                ", admittances=" + admittances +
                ", team=" + team +
                ", events=" + events +
                ", status=" + status +
                '}';
    }
}
