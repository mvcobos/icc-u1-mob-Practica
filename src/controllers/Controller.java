package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    private Person[] personas;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods){
        //This es la instancia de la clase en la propia clase = controller.view = view;
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods; //Si el nombre fuese diferente, no iria el this view = vista; 
        System.out.println("Controller created");
    }

    public void start(){
        int option = 0;
        do{
            option = view.showMenu();
            switch(option){
                case 1:
                    inputPersons();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    sortPersons();
                case 100:
                    System.out.println("Adios");
                default:
                    System.out.println("Opcion no valida");
            }
        }
        while(option != 10);
        
    }
    
    public void sortPersons() {
        int sortingOption = view.selectSortingMethod();

        if(sortingOption == 1){
            sortingMethods.sortByNameBubble(personas);
        }else if(sortingOption == 2){
            sortingMethods.sortByAgeWhitSelection(personas);
        } else {
            view.showMessage("Opcion invalida");
        }
    }

    public void inputPersons(){
        int numeroPersonas = view.inputInt("Ingrese el numero de personas: ");
        personas = new Person[numeroPersonas];
        for(int i=0; i < numeroPersonas; i++){
            personas[i] = view.inputPerson();
        }
    }

    public void addPerson(){
        if(personas == null){
            view.showMessage("No existe, ingrese las personas por primera vez");
            inputPersons();
        } else{
            int numeroPersonas = view.inputInt("Ingrese el numero de personas a adicionar: ");
            Person [] personasTotales = new Person[personas.length + numeroPersonas];
    
            for (int i = 0; i < personas.length; i++){
                personasTotales[i] = personas[i];
            }
    
            for (int i = personas.length; i < personasTotales.length; i++){
                personasTotales[i] = view.inputPerson();
            }
    
            personas = personasTotales;
        }
    }
}
