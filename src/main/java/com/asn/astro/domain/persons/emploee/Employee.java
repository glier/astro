package com.asn.astro.domain.persons.emploee;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Employee extends PersonAbstractEntity {

}
