package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
 * de dominio Provincia.
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
@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    //constructor
    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    //sobreescribe metodos de interface usando funciones jpa
    @Override
    public Provincia buscarPorId(Long id) {

//Crearemos el código en el Service de forma tal que si viene un id válido, devuelva una provincia con ese id,
// y como nombre la palabra "PROVINCIA" seguido del id.
        Provincia provinciaId = provinciaRepository.findById(id).orElse(null);
        if (provinciaId != null) {
            provinciaId.setNombre("PROVINCIA"+id);

        }
        return provinciaId;
    }

}
