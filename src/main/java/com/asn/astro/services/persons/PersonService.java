package com.asn.astro.services.persons;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonService<E extends PersonAbstractEntity> {

    Optional<E> save(E entity);

    List<E> saveAll(List<E> entity);

    Optional<E> update(E entity);

//    Optional<E> get(E entity);

    Page<E> getAll(Pageable pageable);

    List<E> getAllbyId(List<Long> ids);

    Boolean deleteById(Long id);

    Boolean delete(E entity);

    Boolean deleteAll(List<E> entity);

    Boolean deleteAll();
}
