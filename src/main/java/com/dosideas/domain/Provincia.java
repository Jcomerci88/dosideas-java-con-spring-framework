package com.dosideas.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Este objeto de dominio utiliza anotaciones para relacionar la clase y sus
 * atributos con una tabla. JPA (a través de Hibernate) utiliza estas anotaciones
 * para acceder a la base de datos e interactuar con objetos de esta clase.
 */
@Entity
public class Provincia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "id_pais")
    private Long id_pais;
    @Column(name="nombre")
    private String nombre;

/** Mismo nombre que tabla
    CREATE TABLE provincia (
            id BIGINT IDENTITY PRIMARY KEY,
            id_pais BIGINT FOREIGN KEY REFERENCES pais,
            nombre VARCHAR(50)
);
*/
/* me marca error al crear constructor , porque?
    public Provincia(Long id, Long id_pais, String nombre) {
        this.id = id;
        this.id_pais = id_pais;
        this.nombre = nombre;
    }
*/

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
