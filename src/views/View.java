package views;
import java.util.Scanner;
import models.Person;

public class View {
   private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }
    
    public int showMenu() {
        System.out.println("*****MENU******");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Adicionar personas");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar persona");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    
    public int inputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

   public void displayPeople(Person[] people){
        if (people == null){
            System.out.println("El arreglo de personas esta vacio, ingrese personas");
        } else {
            for(Person person : people){
                System.out.println("Nombre: " + person.getName() + "  Edad: " + person.getAge());
            }
        }
    }
   
    public Person inputPerson() {
        System.out.print("Ingrese nombre: ");
        String name = scanner.next();
        System.out.print("Ingrese edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }
    
    public String inputString(String message) {
        System.out.print(message);
        return scanner.next();
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
    
    public int selectSearchCriterion() {
        System.out.println("Criterios de búsqueda:");
        System.out.println("1) Por edad");
        System.out.println("2) Por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    
    public void displayPeople(Person[] people) {
        if (people == null || people.length == 0) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }
    
    public void displaySearchResult(Person person) {
        if (person == null) {
            System.out.println("Persona no encontrada.");
        } else {
            System.out.println("Resultado de búsqueda: " + person);
        }
    }
    
    public int selectSortingMethod() {
        System.out.println("Métodos de ordenamiento:");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    
}
