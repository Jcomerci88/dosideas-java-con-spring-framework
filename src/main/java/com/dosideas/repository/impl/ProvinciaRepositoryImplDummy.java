package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;

public class ProvinciaRepositoryImplDummy implements ProvinciaRepository {

    ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();

    @Override
    public Provincia findById(Long id) {
        Provincia provinciaBusq = new Provincia();
        provinciaBusq.setNombre("PROVINCIA");
        provinciaBusq.setId(id);
        return provinciaBusq;
    }



}
