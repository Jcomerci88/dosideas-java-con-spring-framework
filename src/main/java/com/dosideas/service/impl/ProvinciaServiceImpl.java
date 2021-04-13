package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class ProvinciaServiceImpl implements ProvinciaService {


    // se pone por ejercicio
    //ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
    // se saca por ejercicio
    @Autowired
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }


    @Override
    public Provincia buscarPorId(Long id) {
        Provincia retorno = provinciaRepository.findById(id).orElse(null);
        //Provincia retorno = provinciaRepository.findById(id);
        //if (retorno != null) {
        //    retorno.setNombre("PROVINCIA"+id);
        //}
        //System.out.println("pasa por servicio");
        //System.out.println(retorno.getNombre());
        return retorno;

    }

    //mover esta logica de setear provincia al implementador del repository?


}
