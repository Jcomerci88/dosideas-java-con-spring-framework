package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
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
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTestBasico {


    @Test
    public void  buscarPorId_conIdExistente_retornaProvincia()
    {
        Long id = 1L;
        ProvinciaService provinciaService = new ProvinciaServiceImpl();
        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNotNull();
        assertThat(provincia.getId()).isEqualTo(id);
        System.out.println(provincia.getNombre());
        
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        Long id = 21L;

        ProvinciaRepositoryImpl provinciaService = new ProvinciaRepositoryImpl();
        Provincia provincia = provinciaService.findById(id);
        assertThat(provincia).isNull();

        //System.out.println(provincia.getNombre());
        //java.lang.NullPointerException: Cannot invoke "com.dosideas.domain.Provincia.getNombre()" because "provincia" is null
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        ProvinciaRepositoryImpl provinciaService = new ProvinciaRepositoryImpl();
        provinciaService.findById(null);
        fail("Debería haberse lanzado una excepción.");
    }
}
