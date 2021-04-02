package com.dosideas.service;

import com.dosideas.domain.Provincia;

import java.util.List;

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Pais.
 */
public interface ProvinciaService {

    Provincia buscarPorId(Long id);


}