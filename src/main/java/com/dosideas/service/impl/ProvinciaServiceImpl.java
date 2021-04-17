package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
@Transactional

public class ProvinciaServiceImpl implements ProvinciaService {


    // se pone por ejercicio
    //ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
    // se saca por ejercicio
    @Autowired
    private final ProvinciaRepository provinciaRepository;

    //se puede hacer por constructor o por setter
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
    @Override
    public List<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreInvalidoException("Nombre invalido = NULL");
        }
        List<Provincia> provinciasList = provinciaRepository.findByNombre(nombre);
        return provinciasList;
    }
}
    /*
    public Collection<Provincia> buscarProvinciasPorNombreExacto(String nombre){
        Collection<Provincia> retorno = provinciaRepository.findByNombre(nombre);
        return retorno;
    }
 */