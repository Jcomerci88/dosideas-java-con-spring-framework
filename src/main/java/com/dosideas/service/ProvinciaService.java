package com.dosideas.service;

import com.dosideas.domain.Provincia;

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Provincia.
 */
public interface ProvinciaService {

    Provincia buscarPorId(Long id);

}
