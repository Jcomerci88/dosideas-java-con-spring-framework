package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;

import java.util.Collection;
import java.util.List;

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Provincia.
 */
public interface ProvinciaService {

    Provincia buscarPorId(Long id);

    List<Provincia> buscarProvinciasPorNombreExacto(String nombre) throws NombreInvalidoException;

    Collection<Provincia> buscarProvinciasPorNombreExactoCollection(String nombre) throws NombreInvalidoException;

    List<Provincia> buscarProvinciasPorNombreGeneral(String nombreProvincia) throws NombreInvalidoException;

    Provincia insertarProvincia(Provincia provinciaInsert) throws ProvinciaInvalidaException;
//se agrega por api
    List<Provincia> buscarTodosProvincia();

    void borrarProvincia(Provincia provincia);
}
