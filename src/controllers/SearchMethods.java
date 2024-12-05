package controllers;

public class SearchMethods {

    public Person binarySearchByAge(Person[] persons, int age) {
        int left = 0, right = persons.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (persons[mid].getAge() == age) {
                return persons[mid];
            }
            if (persons[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName(Person[] persons, String name) {
        int left = 0, right = persons.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = persons[mid].getName().compareToIgnoreCase(name);
            if (comparison == 0) {
                return persons[mid];
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
