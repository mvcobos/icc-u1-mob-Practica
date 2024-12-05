package controllers;

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
        searchMethods.setSortedByAge(false);
        searchMethods.setSortedByName(false);
        if (persons == null){
            view.showMessage("No existe el arreglo, ingrese las personas por primera vez");
            inputPersons();
        } else {
            int numeroPersonas = view.inputInt("Ingrese el numero de persona a adicionar: ");
        
        Person[] personsTemp = new Person[persons.length + numeroPersonas];

        for (int i = 0; i < persons.length; i++){
            personsTemp[i] = persons[i];
        }

        for (int i = persons.length; i < personsTemp.length; i++){
            personsTemp[i] = view.inputPerson();
        }
        }
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

    private void searchPerson() {
        if (people == null || people.length == 0) {
            view.showMessage("No hay personas para buscar.");
            return;
        }
        int searchOption = view.selectSearchCriterion();
        switch (searchOption) {
            case 1:
                int age = view.inputInt("Ingrese la edad a buscar: ");
                Person resultByAge = searchMethods.binarySearchByAge(people, age);
                view.displaySearchResult(resultByAge);
                break;
            case 2:
                String name = view.inputString("Ingrese el nombre a buscar: ");
                Person resultByName = searchMethods.binarySearchByName(people, name);
                view.displaySearchResult(resultByName);
                break;
            default:
                view.showMessage("Criterio de búsqueda inválido.");
        }
    }
}
