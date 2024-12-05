package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - i - 1; j++) {
                if (people[j].getName().compareTo(people[j + 1].getName()) > 0) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }
    
    public void sortByNameWithSelectionDesc(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getName().compareTo(people[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            Person temp = people[maxIdx];
            people[maxIdx] = people[i];
            people[i] = temp;
        }
    }
    
    public void sortByAgeWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getAge() > key.getAge()) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = key;
        }
    }
    
    public void sortByNameWithInsertion(Person[] people) {
        for (int i = 1; i < people.length; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && people[j].getName().compareTo(key.getName()) > 0) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = key;
        }
    }

}
