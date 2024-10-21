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
    
}
