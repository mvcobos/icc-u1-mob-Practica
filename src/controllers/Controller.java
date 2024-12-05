package controllers;
import java.util.Scanner;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] people;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods){
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start() {
        int option = 0;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPeople();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    sortPeople();
                    break;
                case 4:
                    int resultado = searchPerson();
                    view.displaySearchResult(people, resultado);
                    break;
                case 5:
                    view.displayPeople(people);
                    break;
                default:
                    view.showMessage("Opción no válida.");
            }
        } while (option != 0);
    }

    private void inputPeople() {
        int count = view.inputInt("Ingrese el número de personas: ");
        people = new Person[count];
        for (int i = 0; i < count; i++) {
            people[i] = view.inputPerson();
        }
    }

    private void addPerson() {
        if (people == null) {
            view.showMessage("Primero debe ingresar personas.");
            inputPeople();
            return;
        }
        int newCount = view.inputInt("Ingrese cuántas personas desea agregar: ");
        Person[] newpeople = new Person[people.length + newCount];
        System.arraycopy(people, 0, newpeople, 0, people.length);
        for (int i = people.length; i < newpeople.length; i++) {
            newpeople[i] = view.inputPerson();
        }
        people = newpeople;
    }

    public static int hasNextInt(Scanner leer, String mensaje, boolean permitirNegativos){
        int arrayLength = 0;

        do{
            System.out.print(mensaje);
            while (!leer.hasNextInt()) {
                System.out.println("Ingrese un entero  positivo valido");
                System.out.print(mensaje);
                leer.next();
            }
            arrayLength = leer.nextInt();
            if (!permitirNegativos && arrayLength < 0){
                System.out.println("Opcion incorrecta");
            }
        } while(! permitirNegativos && arrayLength < 0);
        return arrayLength;
    
    }
    
    private void sortPeople() {
        if (people == null || people.length == 0) {
            view.showMessage("No hay personas para ordenar.");
            return;
        }
        int sortOption = view.selectSortingMethod();
        switch (sortOption) {
            case 1:
                sortingMethods.sortByNameWithBubble(people);
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDesc(people);
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(people);
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(people);
                break;
            default:
                view.showMessage("Opción de ordenamiento inválida.");
        }
        view.displayPeople(people);
    }

    private int searchPerson() {
        int searchOption = view.selectSearchCriterion();
        int resultado = -2;
            switch (searchOption) {
                case 2:
                if (searchMethods.isSortedByName()){
                    String name = view.inputName();
                    resultado = searchMethods.binarySearchByName(people, name);
                } else {
                    view.showMessage("No se puede buscar en el arreglo si no esta ordenado por nombre");
                }
                break;
            
                case 1:
                if (searchMethods.isSortedByAge()){
                    int age = view.inputAge();
                    resultado = searchMethods.binarySearchByAge(people, age);
                } else {
                    view.showMessage("No se puede buscar en el arreglo si no esta ordenado por edad");
                }
                    break;

                default:
                    view.showMessage("Opcion no valida");
                    break;
            }
        return resultado;
    }
}
