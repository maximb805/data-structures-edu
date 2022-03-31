package edu.datastructures.Arrays;


import java.time.LocalDate;

public class ClassArray {
    private Person[] persons;
    private int elemNumber;

    public ClassArray(int size) {
        persons = new Person[size];
        elemNumber = 0;
    }

    public void addPerson(String firstName, String lastName, LocalDate dateOfBirth) {
        if (elemNumber == persons.length) {
            System.out.println("Array' full");
            return;
        } else {
            Person person = new Person(firstName, lastName, dateOfBirth);
            persons[elemNumber++] = person;
        }
    }

    public void addPerson(Person person) {
        if (elemNumber == persons.length) {
            System.out.println("Array' full.");
            return;
        } else {
            persons[elemNumber++] = person;
        }
    }

    public Person find(String lastName) {
        if (elemNumber == 0) {
            System.out.println("Array's empty.");
        } else {
            System.out.println("Found by last name " + lastName + ": ");
            int i;
            for (i = 0; i < elemNumber; i++) {
                if (persons[i].getLastName().equals(lastName)) {
                    System.out.println(persons[i].getFirstName() + " "
                            + persons[i].getLastName() + " " + persons[i].getDateOfBirth());
                    return persons[i];
                }
            }
            System.out.println("Person with last name " + lastName + " not found.");
        }
        return null;
    }

    public Person find(String firstName, String lastName) {
        if (elemNumber == 0) {
            System.out.println("Array's empty.");
        } else {
            System.out.println("Found by name " + firstName + " " + lastName + ": ");
            int i;
            for (i = 0; i < elemNumber; i++) {
                if (persons[i].getLastName().equals(lastName) && persons[i].getFirstName().equals(firstName)) {
                    System.out.println(persons[i].getFirstName() + " "
                            + persons[i].getLastName() + " " + persons[i].getDateOfBirth());
                    return persons[i];
                }
            }
            System.out.println("Person with name " + firstName + " " + lastName + " not found.");
        }
        return null;
    }

    public void displayAll() {
        for (int i = 0; i < elemNumber; i++) {
            System.out.println(i + ") " + persons[i].getFirstName() + " "
                    + persons[i].getLastName() + " " + persons[i].getDateOfBirth());
        }
    }

    public void displayByIndex(int index) {
        if (index > elemNumber - 1 || persons[index] == null) {
            System.out.println("There's no person with index: " + index);
        } else {
            System.out.println(persons[index].getFirstName() + " "
                    + persons[index].getLastName() + " " + persons[index].getDateOfBirth());
        }
    }

    public void delete(String lastName) {
        if (elemNumber == 0) {
            System.out.println("Array's empty.");
        } else {
            for (int i = 0; i < elemNumber; i++) {
                if (persons[i].getLastName().equals(lastName)) {
                    for (int j = i; j < elemNumber - 1; j++) {
                        persons[j] = persons[j + 1];
                    }
                    elemNumber--;
                }
            }
        }
    }

    public void delete(String firstName, String lastName) {
        if (elemNumber == 0) {
            System.out.println("Array's empty.");
        } else {
            for (int i = 0; i < elemNumber; i++) {
                if (persons[i].getLastName().equals(lastName) && persons[i].getFirstName().equals(firstName)) {
                    for (int j = i; j < elemNumber - 1; j++) {
                        persons[j] = persons[j + 1];
                    }
                    elemNumber--;
                }
            }
        }
    }

    public void sortByFirstName() {
        for (int i = 1; i < elemNumber; i++) {
            Person buffer = persons[i];
            int j = i;
            while (j > 0 && persons[j - 1].getFirstName().compareTo(buffer.getFirstName()) > 0) {
                persons[j] = persons[j - 1];
                j--;
            }
            persons[j] = buffer;
        }
    }
}

class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void displayPerson() {
        System.out.println(getFirstName() + " " + getLastName() + " " + getDateOfBirth());
    }
}

class ClassArrayUser {
    public static void main(String[] args) {
        ClassArray array = new ClassArray(50);
        Person person = new Person("Nicolas", "Cage", LocalDate.of(1964, 1, 7));

        array.addPerson("Todd", "Howard", LocalDate.of(1971, 4, 25));
        array.addPerson("Mark", "Zuckerberg", LocalDate.of(1984, 5, 14));
        array.addPerson("Edward", "Norton", LocalDate.of(1969, 8, 18));
        array.addPerson("Max", "Payne", LocalDate.of(1977, 2, 4));
        array.addPerson("Dave", "Rodgers", LocalDate.of(1963, 2, 23));
        array.addPerson("Daniel", "Craig", LocalDate.of(1968, 3, 2));
        array.addPerson("Mike", "Tyson", LocalDate.of(1966, 6, 30));
        array.addPerson("John", "Wick", LocalDate.of(1964, 9, 2));
        array.addPerson("Peter", "Parker", LocalDate.of(1975, 6, 27));
        array.addPerson("Michael", "Jackson", LocalDate.of(1958, 8, 29));
        array.addPerson("Benson", "Payne", LocalDate.of(1979, 6, 17));

        array.displayAll();
        System.out.println();

        array.displayByIndex(18);
        array.displayByIndex(5);
        person.displayPerson();
        array.addPerson(person);
        System.out.println();

        array.displayAll();
        System.out.println();

        array.find("Parker");
        array.find("Dave", "Rodgers");
        array.find("Samuel");
        array.find("John", "Smith");

        array.delete("Vasya");
        array.delete("Craig");
        array.delete("Max", "Payne");
        System.out.println();

        array.displayAll();
        System.out.println();

        array.sortByFirstName();
        array.displayAll();
    }
}
