package com.asn.astro.services.persons;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import com.asn.astro.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PersonAbstractService<E extends PersonAbstractEntity, R extends PersonRepository<E>> implements PersonService<E> {

    protected final R repository;

    @Autowired
    public PersonAbstractService(R repository) {
        this.repository = repository;
    }
}
