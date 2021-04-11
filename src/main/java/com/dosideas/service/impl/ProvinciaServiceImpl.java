package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.ProvinciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {


    // se pone por ejercicio
    ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
    // se saca por ejercicio
    //private final ProvinciaRepository provinciaRepository;

    //para que esta aca? se usa?
    //public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
    //    this.provinciaRepository = provinciaRepository;
    //}


    @Override
    public Provincia buscarPorId(Long id) {
        //Provincia retorno = provinciaRepository.buscarPorId(id).orElse(null);
        Provincia retorno = provinciaRepository.findById(id);
        if (retorno != null) {
            retorno.setNombre("PROVINCIA"+id);
        }

        return retorno;
    }

    //mover esta logica de setear provincia al implementador del repository?


}
