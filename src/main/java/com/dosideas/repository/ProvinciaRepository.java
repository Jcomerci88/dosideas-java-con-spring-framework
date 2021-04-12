package com.dosideas.repository;

import com.dosideas.domain.Provincia ;
import org.springframework.data.jpa.repository.JpaRepository;

/** Este es una interfaz de acceso a datos, que utiliza Spring Data para
 * implementar el repositorio.
 * Contiene varios métodos heredados, que permiten buscar Provincia es por distintos
 * criterios, guardar un pais, borrarlo, etc.
 */
public interface ProvinciaRepository extends JpaRepository<Provincia , Long> {
    //comento porque no tiene que acceder a la base real segun el ejercicio

//public interface ProvinciaRepository {
  //  Provincia findById(Long id);


}
