package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.ProvinciaNoEncontradoException;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este es un controlador de presentación (que se define anotándolo con @RestController),
 * que devuelve JSON al cliente.
 * Estos controladores se utilizan para retornar datos en algún formato que sea
 * fácil de consumir por otro programa (a diferencia de un @Controller de vista,
 * que retorna HTML para que sea visualizado por un ser humano).
 *
 * La anotación @RequestMapping en un método indica que ese método se invoca
 * cuando se recibe una petición HTTP con esa dirección. El método en cuestión
 * devuelve un objeto, que será transformado al formato JSON y retornado al
 * invocante.
 */
@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/{id}")
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradoException, IllegalArgumentException {
        System.out.println("la variable ingresada es : " + id);
        if (id == null) {
            throw new IllegalArgumentException();
        }
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            System.out.println("No se encontro provincia");
            throw new ProvinciaNoEncontradoException("Provincia no encontrado");
            //Este throw para que sirve, donde lo veo?
        }
        return provincia;
    }
}
