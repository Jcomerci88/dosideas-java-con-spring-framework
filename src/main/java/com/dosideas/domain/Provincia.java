package com.dosideas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Este objeto de dominio utiliza anotaciones para relacionar la clase y sus
 * atributos con una tabla. JPA (a través de Hibernate) utiliza estas anotaciones
 * para acceder a la base de datos e interactuar con objetos de esta clase.
 * CREATE TABLE pais (
 *     id BIGINT IDENTITY PRIMARY KEY,
 *     nombre VARCHAR(50)
 * );
 *
 * CREATE TABLE provincia (
 *     id BIGINT IDENTITY PRIMARY KEY,
 *     id_pais BIGINT FOREIGN KEY REFERENCES pais,
 *     nombre VARCHAR(50)
 */
@Entity
public class Provincia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvincia;
    private Long idPais;
    private String nombre;

    public Long getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
