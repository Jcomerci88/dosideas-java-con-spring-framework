package com.dosideas.service.impl;

import com.dosideas.domain.Pais;
import com.dosideas.repository.PaisRepository;
import com.dosideas.service.PaisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
 * de dominio Pais.
 *
 * La anotación @Service es de Spring, y le indica a Spring que esta clase
 * deberá ser tratada como clase de servicios. Spring registrará esta clase para
 * ser inyectada en donde sea necesario.
 *
 * La anotación @Transactional indica que todos los métodos de esta clase
 * deberán ser transaccionales (necesario para JPA).
 *
 * El constructor de esta clase recibe su dependencia obligatoria. Esto le
 * indica a Spring que para constuir una instancia de esta clase deberá primero
 * conseguir una instancia de su dependencia.
 *
 */
@Service
@Transactional
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
//https://dosideas.com/cursos/course/introduccion-al-desarrollo-en-java-con-spring-framework-y-spring-boot/construccion-de-la-clase-de-negocio
// ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
//esta diciendo en vez de acceder a la base con findbyid aca, hacerlo en el repository?
    @Override
    public Pais buscarPorId(Long id) {

        return paisRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pais> buscarTodos() {
        return paisRepository.findAll();
    }

}
/*
 En una arquitectura por capas, se supone que la capa invocante desconoce la implementación de la capa proveedora de
 servicios (de forma tal de ser independiente de la implementación). Sin embargo, aquí, nuestro Service conoce
 explícitamente la implementación del Repository de Provincia... de hecho, está haciendo un "new" de esa implementación!

 Resumiendo, tenemos 1 problema importante: El Service conoce la implementación del Repository. No se puede cambiar
 facilmente la implementación en los Service.

¿Cómo se podría solucionar este problema? ¿Qué alternativas se te ocurren?

Repaso:

La arquitectura se basa entonces en 3 capas principales:

Capa de presentación  = app / api
Capa de lógica de negocio = service
Capa de acceso a datos   = repository


Resolucion:

Ya que el problema es realizar el "new", es evidente que nuestro Service no deberá más instanciar él mismo al
Repository. Es decir, delegaremos la instanciación de este Repositorya un tercero.

Aquí aplicaremos un patrón que será fundamental en el diseño de nuestras aplicaciones JEE: se trata de la Inyección
 de Dependencia (Dependency Inyection - DI). Este patrón establece que un objeto no es el responsable de setear sus
 dependencias, sino que las mismas deben ser seteadas por un tercero.


 */