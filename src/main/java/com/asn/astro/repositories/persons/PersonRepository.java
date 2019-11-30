package com.asn.astro.repositories.persons;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<E extends PersonAbstractEntity> extends JpaRepository<E, Long> {
}
