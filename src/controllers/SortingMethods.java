package controllers;

import models.Person;

public class SortingMethods {

    public Person binarySearchByAge(Person[] people, int age) {
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (people[mid].getAge() == age) {
                return people[mid];
            }
            if (people[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    
    public Person binarySearchByName(Person[] people, String name) {
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = people[mid].getName().compareToIgnoreCase(name);
            if (comparison == 0) {
                return people[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

}
