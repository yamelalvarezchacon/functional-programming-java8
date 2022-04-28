package util;

public class StringUtils {

    /** Metodos que se añaden a la clase String a partir de la version 11 de Java*/

    public static void repeatStringFiveTimes() {
        String output = "Soaint ".repeat(5) + "la mejor opción.";
        System.out.println(output);
    }

    //strip es consciente de los caracteres de espacio en blanco de Unicode
    public static void stripStringWithoutWhitespaces() {
        String stripString = "\n\t  hello   \u2005".strip();
        System.out.println(stripString);
    }

    //removes all the whitespaces only at the starting of the string
    public static void stripLeadingExample() {
        String name = "         Hello, World         ";
        System.out.println("#" + name.stripLeading() + "#");
    }

    //removes all the whitespaces only at the end of the string
    public static void stripTrailingExample() {
        String name = "         Hello, World         ";
        System.out.println("#" + name.stripTrailing() + "#");
    }

    //isBlank returns true if the string is empty or contains only whitespace
    public static void isBlankString() {
        Boolean isBlankString = "\n\t\u2005  ".isBlank();
        System.out.println(isBlankString);
    }

    public static void returnLinesFromString() {
        String multilineStr = "This is\n \n a multiline\n string.";
        long linesCount = multilineStr.lines().count();
        long linesemptyCount = multilineStr.lines()
                .filter(String::isBlank)
                .count();
        System.out.println("Cantidad de lineas: " + linesCount + "\nCantidad de lineas vacias: " + linesemptyCount);
    }
}
