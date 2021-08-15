package testdominio;

import dominio.Persona;
import exceptions.ExceptionPersonaAlturaIncorrecto;
import exceptions.ExceptionPersonaAtributoNulo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import javax.persistence.OrderBy;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersona {
    @Test
    @Order(1)
    public void Test01_CrearPersona_Sin_Errores() throws ExceptionPersonaAtributoNulo, ExceptionPersonaAlturaIncorrecto {
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,3472512, LocalDate.of(1989,11,07));
        //act

        //assert
        assertNotNull(p1);

        //usar patron factory
    }
    @Test
    @Order(2)
    public void test02_Persona_NombreNulo(){
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> {
            Persona p1 = Persona.instaciaPersona(2, null, "Reyna",1.80,92.0,34724517,LocalDate.of(1989,11,07));
        });

    }

    @Test
    @Order(3)
    public void test03_Persona_ApellidoNulo(){
        assertThrows(ExceptionPersonaAtributoNulo.class, () ->{
            Persona p1 = Persona.instaciaPersona(2, "Maximiliano", null,1.80,92.0,34724517,LocalDate.of(1989,11,07));
        });
    }

    @Test
    @Order(4)
    public void test04_Persona_AlturaIncorrecta(){
        assertThrows(ExceptionPersonaAlturaIncorrecto.class, () ->{
            Persona p1 = Persona.instaciaPersona(2, "Maximiliano", "Reyna",-1.58,92.0,34724517,LocalDate.of(1989,11,07));
        });
    }

    @Test
    @Order(5)
    public void test05_Persona_AlturaIncorrecta(){
        assertThrows(ExceptionPersonaAlturaIncorrecto.class, () ->{
            Persona p1 = Persona.instaciaPersona(2, "Maximiliano", "Reyna",0,92.0,34724517,LocalDate.of(1989,11,07));
        });
    }

}
