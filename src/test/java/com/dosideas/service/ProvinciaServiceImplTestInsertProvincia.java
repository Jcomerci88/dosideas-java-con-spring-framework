package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
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
public class ProvinciaServiceImplTestInsertProvincia {

    @Autowired
    ProvinciaService instance;


    @Test
    public void  InsertProvincia_conNombreNuevo_retornaProvincia() throws NombreInvalidoException, ProvinciaInvalidaException {
        //diferencia entre collection y list , porque collection no me andaba?(sugerencia curso)
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(24L);
        provinciaInsert.setNombre("Islas Malvinas");
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        assertThat(provinciaInsertada).isNotNull();
        System.out.println("Se inserto provincia : " + provinciaInsertada.getNombre());

        String nombreProvincia = "Islas malvinas";
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreGeneral(nombreProvincia);
        assertThat(provinciaList).isNotNull();
        for (Provincia regArrayList:provinciaList){
            assertThat(regArrayList.getNombre()).isEqualToIgnoringCase(nombreProvincia);
            //assertThat(regArrayList.getNombre()).isEqualTo(nombreProvincia);
            System.out.println("valor encontrado : " + regArrayList.getNombre() + " valor entrada: " + nombreProvincia);
            System.out.println(regArrayList.getId());
        }

//este insert es en tiempo real y luego se borra por como esta realizada la base calculo, si hago el test por afuera no encuentra


    }



    @Test(expected = NombreInvalidoException.class)

    public void  buscarPorNombre_conNombreNull_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto(null);
        fail("Debería haberse lanzado una excepción.");

    }
    @Test(expected = NombreInvalidoException.class)
    public void  buscarPorNombre_conNombreMenor3Letras_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto("AB");
        fail("Debería haberse lanzado una excepción.");


    }
}
