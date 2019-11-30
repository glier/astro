package com.asn.astro.services.persons;

import com.asn.astro.domain.persons.emploee.Employee;
import com.asn.astro.repositories.persons.EmployeeRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService extends PersonAbstractService<Employee, EmployeeRepository> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Employee> save(Employee entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public List<Employee> saveAll(List<Employee> entity) {
        return Lists.newArrayList(repository.saveAll(entity));
    }

    @Override
    public Optional<Employee> update(Employee entity) {
        return Optional.of(repository.save(entity));
    }

//    @Override
//    public Optional<Employee> get(Employee entity) {
//        return entity;
//    }

    @Override
    public Page<Employee> getAll(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Employee> getAllbyId(List<Long> ids) {
        return Lists.newArrayList(repository.findAllById(ids));
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }

    @Override
    public Boolean delete(Employee entity) {
        repository.delete(entity);
        return !repository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll(List<Employee> entity) {
        repository.deleteAll(entity);
        return Lists.newArrayList(repository.findAllById(entity.stream().map(Employee::getId).collect(Collectors.toList()))).isEmpty();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        return Lists.newArrayList(repository.findAll()).isEmpty();
    }
}
