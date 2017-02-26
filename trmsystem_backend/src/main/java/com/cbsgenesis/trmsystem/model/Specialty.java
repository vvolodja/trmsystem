package com.cbsgenesis.trmsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object that represents a Specialty of {@link Specialist}.
 *
 * @author Eugene Suleimanov
 */

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
}
