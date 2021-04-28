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
    public void  InsertProvincia_conNombreNuevo_retornaSave() throws NombreInvalidoException, ProvinciaInvalidaException {
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(24L);
        provinciaInsert.setNombre("Islas Malvinas");
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        //como valido si fue insertada o no?
        assertThat(provinciaInsertada).isNotNull();
        System.out.println("Se inserto provincia : " + provinciaInsertada.getNombre());

        Provincia provinciaInsertada1 = instance.insertarProvincia(provinciaInsert);
        assertThat(provinciaInsertada1).isNotNull();


        //busco para ver si inserto o no
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

    @Test
    public void  InsertProvincia_conIdExistente_retornaSave() throws NombreInvalidoException, ProvinciaInvalidaException {
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(18L);
        provinciaInsert.setNombre("Islas Malvinas");
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        //como valido si fue insertada o no?
        assertThat(provinciaInsertada).isNotNull();
        System.out.println("Se inserto provincia : " + provinciaInsertada.getNombre());

        //busco para ver si inserto o no
        String nombreProvincia = "Islas malvinas";
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreGeneral(nombreProvincia);
        assertThat(provinciaList).isNotNull();
        for (Provincia regArrayList:provinciaList){
            assertThat(regArrayList.getNombre()).isEqualToIgnoringCase(nombreProvincia);
            System.out.println("valor encontrado : " + regArrayList.getNombre() + " valor entrada: " + nombreProvincia);
            System.out.println(regArrayList.getId());
        }
        //el save no solo inserta sino que actualiza
    }


    @Test(expected = ProvinciaInvalidaException.class)

    public void  InsertProvincia_conIdNull_retornaExcepcion() throws ProvinciaInvalidaException {
        //no veo la excepcion
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(null);
        provinciaInsert.setNombre("Pepe");
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = ProvinciaInvalidaException.class)

    public void  InsertProvincia_conNombre_retornaExcepcion() throws ProvinciaInvalidaException {
        //no veo la excepcion
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(5l);
        provinciaInsert.setNombre(null);
        provinciaInsert.setId_pais(1L);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = ProvinciaInvalidaException.class)

    public void  InsertProvincia_conIdPaisNull_retornaExcepcion() throws ProvinciaInvalidaException {
        //no veo la excepcion
        Provincia provinciaInsert = new Provincia();
        provinciaInsert.setId(1l);
        provinciaInsert.setNombre("Pepe");
        provinciaInsert.setId_pais(null);
        Provincia provinciaInsertada =  instance.insertarProvincia(provinciaInsert);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = NombreInvalidoException.class)

    public void  buscarPorNombre_conNombreMenor3Letras_retornaExcepcion() throws NombreInvalidoException {
        List<Provincia> provinciaList =  instance.buscarProvinciasPorNombreExacto("AB");
        fail("Debería haberse lanzado una excepción.");


    }
}
