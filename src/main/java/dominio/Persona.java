package dominio;

import exceptions.ExceptionPersonaAlturaIncorrecto;
import exceptions.ExceptionPersonaAtributoNulo;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private double altura;
    private double peso;
    private int dni;
    private LocalDate fechaNac;

    public Persona(int id, String nombre, String apellido, double altura, double peso, int dni, LocalDate fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    public static Persona instaciaPersona(int id, String nombre, String apellido, double altura, double peso, int dni, LocalDate fechaNac) throws ExceptionPersonaAtributoNulo, ExceptionPersonaAlturaIncorrecto {
        if(nombre == null){
            throw new ExceptionPersonaAtributoNulo("Error: El nombre no puede ser nulo");
        }
        if(apellido == null){
            throw new ExceptionPersonaAtributoNulo("Error: El apellido no puede ser nulo");
        }
        if(altura < 0 ){
            throw new ExceptionPersonaAlturaIncorrecto("Error: La altura no puede ser negativa");
        }

        return new Persona( id, nombre, apellido, altura, peso, dni, fechaNac);
    }


    //aca programar la clase
    //agregar metodo instanciaPersona
}
