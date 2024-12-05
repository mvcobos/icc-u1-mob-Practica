import controllers.*;
import views.View;

public class App {
    public static void main(String[] args) throws Exception {
        
        //CREAR LA VISTA
        View view = new View();
        
        //MCrear las clases con los metodos de ordenamiento y busqueda
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();

        //Crear el controlador
        Controller controller = new Controller(view, sortingMethods, searchMethods);
        controlador.start();
    }
}
