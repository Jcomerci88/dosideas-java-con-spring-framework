package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTestNombreExacto {

    @Autowired
    ProvinciaService instance;

    @Test
    public void  buscarPorNombre_conNombreExistente_retornaProvinciaCollection() throws NombreInvalidoException {
        //diferencia entre collection y list , porque collection no me andaba?(sugerencia curso)
        String nombreProvincia = "Buenos Aires";
        Collection<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExactoCollection(nombreProvincia);
        assertThat(provinciaList).isNotNull();


        for (Provincia regArrayList:provinciaList){
            assertThat(regArrayList.getNombre()).isEqualTo(nombreProvincia);
            System.out.println(regArrayList.getNombre());
            System.out.println(regArrayList.getId());
        }
    }

    @Test
    public void  buscarPorNombre_conNombreExistente_retornaProvincia() throws NombreInvalidoException {
        //diferencia entre collection y list , porque collection no me andaba?(sugerencia curso)
        String nombreProvincia = "Buenos Aires";
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto(nombreProvincia);
        assertThat(provinciaList).isNotNull();


        for (Provincia regArrayList:provinciaList){
            assertThat(regArrayList.getNombre()).isEqualTo(nombreProvincia);
            System.out.println(regArrayList.getNombre());
            System.out.println(regArrayList.getId());
        }
    }

    @Test(expected = NombreInvalidoException.class)

    public void  buscarPorNombre_conNombreNull_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto(null);
        fail("Deber??a haberse lanzado una excepci??n.");

    }
    @Test(expected = NombreInvalidoException.class)
    public void  buscarPorNombre_conNombreMenor3Letras_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto("AB");
        fail("Deber??a haberse lanzado una excepci??n.");
    }
}
