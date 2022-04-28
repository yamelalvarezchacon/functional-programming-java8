package util;

import model.Persona;
import model.Producto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppUtils {

    public static List<Persona> generarListadoPersonas(){
        Persona persona1 = new Persona(1, "Yamel", LocalDate.of(1991, 1, 21));
        Persona persona2 = new Persona(2, "Jorge", LocalDate.of(1990, 2, 21));
        Persona persona3 = new Persona(3, "Dasiel", LocalDate.of(1980, 6, 23));
        Persona persona4 = new Persona(4, "Mariela", LocalDate.of(2019, 5, 15));
        Persona persona5 = new Persona(5, "Manuel", LocalDate.of(2010, 1, 4));

        return Arrays.asList(persona1, persona2, persona3, persona4, persona5);

    }

    public static List<Persona> generarListadoPersonas2(){
        Persona persona1 = new Persona(6, "Yasser", LocalDate.of(1965, 6, 12));
        Persona persona2 = new Persona(7, "Daniel", LocalDate.of(2000, 8, 1));
        Persona persona3 = new Persona(8, "Orgiel", LocalDate.of(1980, 2, 28));
        Persona persona4 = new Persona(9, "Harvet", LocalDate.of(1990, 4, 25));
        Persona persona5 = new Persona(10, "Duran", LocalDate.of(1988, 10, 4));

        return Arrays.asList(persona1, persona2, persona3, persona4, persona5);

    }

    public static List<Producto> generarListadoProductos(){
        Producto producto1 = new Producto(1, "Pollo", 15.0);
        Producto producto2 = new Producto(2, "Perritos", 25.50);
        Producto producto3 = new Producto(3, "Picadillo", 35.50);
        Producto producto4 = new Producto(4, "Pollo", 15.0);

        return Arrays.asList(producto1, producto2, producto3, producto4);
    }

}
