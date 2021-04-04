package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
 * de dominio Pais.
 *
 * La anotación @Service es de Spring, y le indica a Spring que esta clase
 * deberá ser tratada como clase de servicios. Spring registrará esta clase para
 * ser inyectada en donde sea necesario.
 *
 * La anotación @Transactional indica que todos los métodos de esta clase
 * deberán ser transaccionales (necesario para JPA).
 *
 * El constructor de esta clase recibe su dependencia obligatoria. Esto le
 * indica a Spring que para constuir una instancia de esta clase deberá primero
 * conseguir una instancia de su dependencia.
 *
 */
/*
@Service
@Transactional
public class ProvinciaRepositoryImpl2 implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    public ProvinciaRepositoryImpl2(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public Provincia buscarPorId(Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }

}
*/