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
        System.out.println("5. Desplegar Personas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return controllers.Controller.hasNextInt(scanner, "Escoja una opcion: ", false);
    }
    
   
    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }
   
    public String inputName(){
        System.out.println("Ingrese el nombre: ");
        return scanner.next();
    }

   public int inputAge(){
        return controllers.Controller.hasNextInt(scanner, "Ingrese la edad: ", false);
    }

    public String inputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

   public int inputInt(String mensaje){
        return controllers.Controller.hasNextInt(scanner, mensaje, false);
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
        }else {
            for(Person person : people){
                System.out.println("Nombre: " + person.getName() + "  Edad: " + person.getAge());
            }
        }
    }
    
    public void displaySearchResult(Person[] persons, int resultado){
        if (resultado == -1){
            System.out.println("No se encuentra");
        } else if (resultado == -2){
            System.out.println("");
        } else {
            printObjeto(persons, resultado);
        }
    }
   
    public void printObjeto(Person[] people ,int resultado){
        System.out.println("El dato buscado corresponde a:");
        System.out.println("Nombre: " + people[resultado].getName() + "  Edad: " + people[resultado].getAge());
    }
    
    public int selectSortingMethod() {
        System.out.println("Métodos de ordenamiento:");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        return controllers.Controller.hasNextInt(scanner, "Seleccione una opción: ", false);
    }

}
