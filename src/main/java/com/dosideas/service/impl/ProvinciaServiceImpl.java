package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository paisRepository;

    public ProvinciaServiceImpl(ProvinciaRepository paisRepository) {
        this.paisRepository = paisRepository;
    }


    @Override
    public Provincia buscarPorId(Long id) {
        Provincia retorno = paisRepository.findById(id).orElse(null);
        if (retorno != null) {
            retorno.setNombre("PROVINCIA"+id);
        }

        return retorno;
    }

    //mover esta logica de setear provincia al implementador del repository?


}
