package com.dosideas.repository;

import com.dosideas.domain.Provincia ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Este es una interfaz de acceso a datos, que utiliza Spring Data para
 * implementar el repositorio.
 * Contiene varios métodos heredados, que permiten buscar Provincia es por distintos
 * criterios, guardar un pais, borrarlo, etc.
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia , Long> {
    List<Provincia> findByNombre(String nombre);
    List<Provincia> findByNombreIgnoreCase(String nombre);

    }
