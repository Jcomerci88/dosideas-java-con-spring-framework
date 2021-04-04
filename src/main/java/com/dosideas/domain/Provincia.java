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
    private Long id;
    private Long id_pais;
    private String nombre;
/* !!!!tiene que tener los mismos nombres que la tabla creada*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
