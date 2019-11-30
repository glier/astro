package com.asn.astro.controller.persons;

import com.asn.astro.domain.persons.PersonAbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PersonController<E extends PersonAbstractEntity> {

    @PostMapping("/save")
    ResponseEntity<E> save(@RequestBody E entity);

    @GetMapping("{id}")
    ResponseEntity<E> get(@PathVariable("id") E entity);

    @GetMapping("/all")
    Page<E> getAll(@PageableDefault Pageable pageable);

    @PutMapping("{id}")
    ResponseEntity<E> update(@PathVariable("id") E entity, @RequestBody E body);

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") E entity);
}
