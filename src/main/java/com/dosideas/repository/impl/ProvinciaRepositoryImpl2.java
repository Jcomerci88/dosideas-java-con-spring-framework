package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ProvinciaRepositoryImpl2 implements ProvinciaRepository {

    @Override
    public List<Provincia> findAll() {
        return null;
    }

    @Override
    public List<Provincia> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Provincia> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Provincia> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Provincia entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Provincia> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Provincia> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Provincia> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Provincia> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Provincia> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Provincia> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Provincia getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Provincia> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Provincia> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Provincia> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Provincia> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Provincia> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Provincia> boolean exists(Example<S> example) {
        return false;
    }
}
