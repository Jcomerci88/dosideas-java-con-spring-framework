package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.ProvinciaInvalidaException;
import com.dosideas.exception.ProvinciaNoEncontradaException;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradaException {
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia no encontrada");
        }
        return provincia;
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Provincia> create(@RequestBody Provincia provincia) throws ProvinciaInvalidaException {
        Provincia provinciaCreada = provinciaService.insertarProvincia(provincia);
        return new ResponseEntity(provinciaCreada, HttpStatus.CREATED);
        //esto anda pero no lo entiendo muy bien, ademas de que no se como funciona quitando el postman, haciendo una
        //pagina donde escriba entenderia como se llama, por lo menos simulando
        //porque el id no me lo respeta y guarda el numero proximo?
        /*
        {
        hago post con esto, pero inserta 21 (hay 20)
    "id": 23,
    "id_pais": 1,
    "nombre": "Islas Malvinas"
}
         */

    }


    /*@PostMapping("/post/{id}")
    public void PostProvincia(@PathVariable Long id){
        Provincia provincia = provinciaService.insertarProvincia();
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(null);
        provinciaInsert.setNombre("Pepe");
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
    }
    */
}
