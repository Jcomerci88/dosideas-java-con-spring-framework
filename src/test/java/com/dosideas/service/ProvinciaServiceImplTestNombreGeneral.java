package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTestNombreGeneral {

    @Autowired
    ProvinciaService instance;


    @Test
    public void  buscarPorNombre_conNombreExistente_retornaProvincia() throws NombreInvalidoException {
        //diferencia entre collection y list , porque collection no me andaba?(sugerencia curso)
        String nombreProvincia = "BUenos Aires";
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreGeneral(nombreProvincia);
        assertThat(provinciaList).isNotNull();


        for (Provincia regArrayList:provinciaList){
            assertThat(regArrayList.getNombre()).isEqualToIgnoringCase(nombreProvincia);
            System.out.println("valor encontrado : " + regArrayList.getNombre() + " valor entrada: " + nombreProvincia);
            System.out.println(regArrayList.getId());
        }

    }

    @Test(expected = NombreInvalidoException.class)

    public void  buscarPorNombre_conNombreNull_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreGeneral(null);
        fail("Debería haberse lanzado una excepción.");

    }

}
