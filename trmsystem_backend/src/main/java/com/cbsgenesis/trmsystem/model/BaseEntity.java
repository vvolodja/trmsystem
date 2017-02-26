package com.cbsgenesis.trmsystem.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Base class with property 'id'.
 * Used as a base class for all objects that need this property.
 *
 * @author Eugene Suleimanov
 */

@MappedSuperclass
public class BaseEntity {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
