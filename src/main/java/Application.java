import model.Persona;
import model.Producto;
import util.AppUtils;
import util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

    static List<Producto> productList = AppUtils.generarListadoProductos();
    static List<Persona> personList = AppUtils.generarListadoPersonas();
    static List<Persona> personList2 = AppUtils.generarListadoPersonas2();
    static List<List<Persona>> nestedPersonList = Arrays.asList(personList,personList2);

    public static void main(String[] args) {

            /**Before java 8*/
        //printPersonListBeforeJava8();
        //printPersonListOlderThan18BeforeJava8();
        //printPersonAgeListOlderThan18BeforeJava8();
        //concatStringToPersonNamesBeforeJava8();
        //orderPersonListByBirthDateBeforeJava8();
        //matchUseBeforeJava8();

            /**After java 8 (Lambda functions and streams)*/
        //printPersonList();
        //printPersonListOlderThan18WithFilter();
        //printPersonAgeListOlderThan18WithMap();
        //concatStringToPersonNamesWithMap();
        //orderPersonListByBirthDate();
        //matchUseInJavaStream();
        //limitAndSkipUseInJavaStream();
        //groupByExamplesInJavaStream();
        //obtenerSumaYResumen();
        //reduceExampleEnJavaStream();
        flatMapExampleOlderThan40();
        //flatMapExampleGetAges();

            /** Nuevos metodos en la clase String a partir de java 11 */
        //StringUtils.repeatStringFiveTimes();
        //StringUtils.stripStringWithoutWhitespaces();
        //StringUtils.stripLeadingExample();
        //StringUtils.stripTrailingExample();
        //StringUtils.isBlankString();
        //StringUtils.returnLinesFromString();

    }

    public static void printPersonListBeforeJava8(){
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        for (Persona p : personList) {
            //System.out.println(p);
        }
    }

    public static void printPersonList(){
        //Para cada item de la lista imprime el valor de la persona
        personList.forEach(p -> System.out.println(p));
        //Metodo referenciado
        //personList.forEach(System.out::println);
    }

    public static void printPersonListOlderThan18BeforeJava8() {
        List<Persona> personThan18 = new ArrayList<Persona>();
        for (Persona p : personList) {
            if (Application.getAge(p.getBirthDate()) > 18) {
                personThan18.add(p);
            }
        }
        Application.printList(personThan18);
    }

    public static void printPersonListOlderThan18WithFilter() {
        // Filter (param: Predicate)
        List<Persona> filteredList1 = personList.stream()
                .filter(p -> Application.getAge(p.getBirthDate()) >= 18)
                .collect(Collectors.toList());
        Application.printList(filteredList1);
    }

    public static void printPersonAgeListOlderThan18BeforeJava8() {
        List<Integer> personAgeThan18 = new ArrayList<Integer>();
        for (Persona p : personList) {
            if (Application.getAge(p.getBirthDate()) > 18) {
                personAgeThan18.add(Application.getAge(p.getBirthDate()));
            }
        }
        Application.printList(personAgeThan18);
    }

    public static void printPersonAgeListOlderThan18WithMap() {
        // Map (param: Function) tranforma los elemntos de la coleccion
        List<Integer> personsAge = personList.stream()
                .filter(p -> Application.getAge(p.getBirthDate()) >= 18)
                .map(p -> Application.getAge(p.getBirthDate()))
                .collect(Collectors.toList());
        Application.printList(personsAge);
    }

    public static void concatStringToPersonNamesBeforeJava8() {
        List<String> concatNames = new ArrayList<String>();
        for (Persona p : personList) {
            concatNames.add("Soaint " + p.getName());
        }
        Application.printList(concatNames);
    }

    public static void concatStringToPersonNamesWithMap() {
        List<String> concatNamesStream = personList.stream()
                .map(p -> "Soaint " + p.getName())
                .collect(Collectors.toList());
        Application.printList(concatNamesStream);

        /*Function<String, String> concatNamesFunction = name -> "Soaint " + name;
        List<String> concatNamesStreamFunction = personList.stream().map(p -> p.getName())
                .map(concatNamesFunction)
                .collect(Collectors.toList());
        Application.printList(concatNamesStreamFunction);*/
    }

    public static void orderPersonListByBirthDateBeforeJava8() {
        Persona[] array = new Persona[personList.size()];
        for (int i = 0; i <= personList.size() - 1; i++) {
            array[i] = personList.get(i);
        }
        List<Persona> personasOrdenadas = burbuja(array); //Ordena el listado de personas por fecha nacimiento
        for (Persona p : personasOrdenadas) {
            System.out.println(p);
        }
    }

    public static void orderPersonListByBirthDate() {
        // 3-Sorted (param: Comparator) Ordenar a traves de una coleccion
        Comparator<Persona> byNameAsc = (Persona o1, Persona o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Persona> byNameDesc = (Persona o1, Persona o2) -> o2.getName().compareTo(o1.getName());
        Comparator<Persona> byBirthDate = (Persona o1, Persona o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());

        List<Persona> orderedList = personList.stream()
                .sorted(byBirthDate)
                .collect(Collectors.toList());
        Application.printList(orderedList);
    }

    public static void matchUseBeforeJava8() {
        int cont = 0;
        for (Persona p : personList) {
            if (p.getName().startsWith("J")) {
                cont++;
                break;
            }
        }
        if (cont > 0) {
            System.out.println("true");
        }
    }

    public static void matchUseInJavaStream() {
        // 4-Match (param: Predicate

        Predicate<Persona> startsWithPredicate = person -> person.getName().startsWith("J");
        // anyMatch : No evalua todo el stream, termina en la coincidencia
        boolean anyMatch = personList.stream().anyMatch(startsWithPredicate);
        System.out.println(anyMatch);

        // allMatch : Evalua todo el stream bajo la condicion
        boolean allMatch = personList.stream().allMatch(startsWithPredicate);
        System.out.println(allMatch);

        // noneMatch : Evalua todo el stream bajo la condicion
        boolean noneMatch = personList.stream().noneMatch(startsWithPredicate);
        System.out.println(noneMatch);
    }

    public static void limitAndSkipUseInJavaStream() {
        int pageNumber = 0;
        int pageSize = 2;
        List<Persona> paginatedList = personList.stream()
                .skip(pageNumber * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        Application.printList(paginatedList);
    }

    public static void groupByExamplesInJavaStream() {
        // GroupBy
        Map<String, List<Producto>> collect1 = productList.stream()
                .filter(p -> p.getPrice() > 20)
                .collect(Collectors.groupingBy(Producto::getName));
        System.out.println(collect1);


        // Counting
        Map<String, Long> collect2 = productList.stream()
                .collect(Collectors.groupingBy(Producto::getName, Collectors.counting()));
        System.out.println(collect2);


        //Agrupando por nombre producto y sumando
        Map<String, Double> collect3 = productList.stream()
                .collect(Collectors.groupingBy(Producto::getName, Collectors.summingDouble(Producto::getPrice)));
        System.out.println(collect3);
    }

    public static void obtenerSumaYResumen() {
        DoubleSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingDouble(Producto::getPrice));
        System.out.println(statistics);
    }

    public static void reduceExampleEnJavaStream() {
        Optional<Double> sum = productList.stream()
                .map(Producto::getPrice)
                .reduce(Double::sum);
        System.out.println(sum.get());
    }

    private static void flatMapExampleOlderThan40() {
        //map() is used for transformation only, but flatMap() is used for both transformation and flattening.
        List<Persona> listofPersons  = nestedPersonList.stream()
                .flatMap(Collection::stream)
                .filter(persona -> Application.getAge(persona.getBirthDate()) > 40)
                .collect(Collectors.toList());
        listofPersons.forEach(System.out::println);
    }

    private static void flatMapExampleGetAges() {
        List<Integer> listofPersons  = nestedPersonList.stream()
                .flatMap(Collection::stream)
                .map(persona -> Application.getAge(persona.getBirthDate()))
                .collect(Collectors.toList());
        listofPersons.forEach(System.out::println);
    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
    private static List<Persona> burbuja(Persona[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
            for (int y = 0; y < arreglo.length - 1; y++) {
                Persona elementoActual = arreglo[y], elementoSiguiente = arreglo[y + 1];
                if (Application.getAge(elementoActual.getBirthDate()) < Application.getAge(elementoSiguiente.getBirthDate())) {
                    // Intercambiar
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }
        return Arrays.asList(arreglo);
    }
}
