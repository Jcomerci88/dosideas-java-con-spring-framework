package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import com.dosideas.dummy.ProvinciaRepositoryDummy;
import com.dosideas.service.impl.ProvinciaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)  //sin esto no funciona test autowired
public class ProvinciaServiceImplTestBasico {

    @Autowired
    ProvinciaService instance;

    @Test
    public void  buscarPorId_conIdExistente_retornaProvincia()
    {
        Long id = 10L;
        // esto es inyeccion de dependencia
        //ProvinciaService provinciaService = new ProvinciaServiceImpl(new ProvinciaRepositoryDummy());
        //Provincia provincia = provinciaService.buscarPorId(id);

        ProvinciaService provinciaService = new ProvinciaServiceImpl(new ProvinciaRepositoryDummy());
        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNotNull();
        assertThat(provincia.getId()).isEqualTo(id);
        System.out.println(provincia.getNombre());

    }

    @Test
    public void  buscarPorId_conIdExistente_retornaProvincia_autowired()
    {
        Long id = 10L;
        // esto es inyeccion de dependencia
        //ProvinciaService provinciaService = new ProvinciaServiceImpl(new ProvinciaRepositoryDummy());
        //Provincia provincia = provinciaService.buscarPorId(id);

        Provincia provincia =  instance.buscarPorId(id);

        assertThat(provincia).isNotNull();
        assertThat(provincia.getId()).isEqualTo(id);
        System.out.println(provincia.getNombre());

    }
    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        Long id = 23L;

        //si quiero usar ProvinciaRepository normal, es una interface no me va a dejar instanciar, deberia crear una
        //con cero funcionalidad?
        ProvinciaService provinciaService = new ProvinciaServiceImpl(new ProvinciaRepositoryDummy());

        Provincia provinciaNull = provinciaService.buscarPorId(id);

        assertThat(provinciaNull).isNull();
        System.out.println("provincia null es : " + provinciaNull);

        /*
        Ahora bien, cuando ejecutes los tests, los mismos fallarán por un simpático NullPointerException seguramente...
         y es que, ¿quién está seteando a nuestro Repository? Será entonces nuestro test quien deba crear una instancia
         del Repository, setearsela al Service, y recién entonces ejecutar el test. A modificar el test entonces!
         */

        //me da error porque ejecuta ProvinciaRepositoryDummy , lo comentaré
        //el error daba porque no puedo hacer sout sobre algo que es nulo

        //System.out.println(provincia.getNombre());
        //java.lang.NullPointerException: Cannot invoke "com.dosideas.domain.Provincia.getNombre()" because "provincia" is null
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        ProvinciaService provinciaService = new ProvinciaServiceImpl(new ProvinciaRepositoryDummy());
        provinciaService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
}
