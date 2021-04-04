package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

/** Este es una interfaz de acceso a datos, que utiliza Spring Data para
 * implementar el repositorio.
 * Contiene varios métodos heredados, que permiten buscar Paises por distintos
 * criterios, guardar un pais, borrarlo, etc.
 */
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
  //Provincia findById(Long id); //esto va aca?
}
