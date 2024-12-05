package controllers;
import models.Person;

public class SearchMethods {
    private boolean sortedByAge = false;
    private boolean sortedByName = false;

    public int binarySearchByAge(Person[] persons, int datoBuscar){
        int inicio = 0;
        int fin = persons.length - 1;
        while (inicio <= fin){
            int mid = (inicio + fin) / 2;
            if(persons[mid].getAge() == datoBuscar){
                return mid;
            }
            if(persons[mid].getAge() > datoBuscar){
                inicio = mid + 1;
            }
            if (persons[mid].getAge() < datoBuscar){
                fin = mid - 1;
            }
        }
        return -1;
    }


    public int binarySearchByName(Person[] persons, String datoBuscar){
        int inicio = 0;
        int fin = persons.length - 1;
        while (inicio <= fin){
            int mid = (inicio + fin) / 2;
            if(persons[mid].getName().compareTo(datoBuscar) == 0){
                return mid;
            }
            if(persons[mid].getName().compareTo(datoBuscar) < 0){
                inicio = mid + 1;
            }
            if (persons[mid].getName().compareTo(datoBuscar) > 0){
                fin = mid - 1;
            }
        }
        return -1;
    }

    public boolean isSortedByAge() {
        return sortedByAge;
    }


    public void setSortedByAge(boolean sortedByAge) {
        this.sortedByAge = sortedByAge;
    }


    public boolean isSortedByName() {
        return sortedByName;
    }


    public void setSortedByName(boolean sortedByName) {
        this.sortedByName = sortedByName;
    }
  
}
