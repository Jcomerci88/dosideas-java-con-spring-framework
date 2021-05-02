package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
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
    @Override
    public List<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreInvalidoException("Nombre invalido = NULL");
        }
        List<Provincia> provinciasList = provinciaRepository.findByNombre(nombre);
        return provinciasList;
    }


    public Collection<Provincia> buscarProvinciasPorNombreExactoCollection(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreInvalidoException("Nombre invalido = NULL");
        }
        Collection<Provincia> provinciasList = provinciaRepository.findByNombre(nombre);
        return provinciasList;
    }

    @Override
    public List<Provincia> buscarProvinciasPorNombreGeneral(String nombreProvincia) throws NombreInvalidoException {
        if (nombreProvincia == null)  {
            //agregar log de excepcion
            throw new NombreInvalidoException("Nombre invalido = NULL");
        }
        List<Provincia> provinciasList = provinciaRepository.findByNombreIgnoreCase(nombreProvincia);
        return provinciasList;
    }

    @Override
    public Provincia insertarProvincia(Provincia provinciaInsert) throws ProvinciaInvalidaException {
        if (provinciaInsert.getId() == null ) {
            System.out.println("Insertar provincia excepcion por id nulo");
            throw new ProvinciaInvalidaException("Id es nulo");
        }
        if (provinciaInsert.getId_pais() == null){
            System.out.println("Insertar provincia excepcion por id_pais nulo");
            throw new ProvinciaInvalidaException("Id_pais es nulo");
        }
        if (provinciaInsert.getNombre() == null){
            System.out.println("Insertar provincia excepcion por nombre nulo");
            throw new ProvinciaInvalidaException("Nombre es nulo");
        }
        if (provinciaInsert.getNombre().length() < 3) {
            throw new ProvinciaInvalidaException("El nombre debe ser mayor a 2 caracteres");
        }
        // como se deberia retorna lo que devuelva el insert?
        return provinciaRepository.save(provinciaInsert);
    }

    @Override
    public List<Provincia> buscarTodosProvincia() {
        return provinciaRepository.findAll();
    }

    @Override
    public void borrarProvincia(Provincia provincia) {
         provinciaRepository.delete(provincia);
        }
}




