package com.asn.astro.controller.persons;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import com.asn.astro.domain.persons.emploee.Employee;
import com.asn.astro.exceptions.NotFoundException;
import com.asn.astro.services.persons.PersonService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

public abstract class PersonAbstractController<E extends PersonAbstractEntity, S extends PersonService<E>> implements PersonController<E> {

    private final S service;

    @Autowired
    public PersonAbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> save(E entity) {
        return service.save(entity).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException());
    }


//    @Override
//    public ResponseEntity<E> get(Long id) {
//        return service.get(id).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException());
//    }


    @Override
    public ResponseEntity<E> get(E entity) {
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @Override
    public Page<E> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @Override
    public ResponseEntity<E> update(E entity, E body) {
        BeanUtils.copyProperties(body, entity, "id");
        return service.update(entity).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void delete(E entity) {
        service.delete(entity);
    }
}
