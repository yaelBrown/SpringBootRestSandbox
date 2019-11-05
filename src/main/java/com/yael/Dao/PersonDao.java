package com.yael.Dao;

import com.yael.Entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonDao {

    private static Map<Integer, Person> people;

    static {
        people = new HashMap<Integer, Person>() {

            {
                put(1, new Person(1, "Yael"));
                put(2, new Person(2, "Steve"));
                put(3, new Person(3, "Ethan"));
            }
        };
    }

    private static int findIdByName(String name) {
        int idx = 0;

        for(Person p : people.values()) {
            if (p.getName().equalsIgnoreCase(name)) {
                idx = p.getId();
            }
        }

        return idx;
    }

    public Collection<Person> getAllPeople() {
        return this.people.values();
    }

    public Collection<Person> getPersonById(int id) {
        return (Collection<Person>) this.people.get(id);
    }

    public static void addPerson(String name) {
        int idx = people.size() + 1;
        people.put(idx, new Person(idx, name));
    }

    public static void deletePerson(String name) {
        int idx = findIdByName(name);
        people.remove(idx);
    }

    public static void updatePerson(String preName, String postName) {
        int idx = findIdByName(preName);
        people.put(idx, new Person(idx, postName));
    }

    public static void main(String[] args) {
        System.out.println("===Add Person===");
        addPerson("Katy");
        addPerson("Pumpkin");
        addPerson("Elmo");

//        System.out.println(people.get(2).getId());

        for(Person p : people.values()) {
            System.out.println(p.getId() + " " + p.getName());
        }

        System.out.println("===Delete Person===");

        deletePerson("Yael");

        for(Person p : people.values()) {
            System.out.println(p.getId() + " " + p.getName());
        }

        System.out.println("===Update Person===");

        updatePerson("Katy", "Katherine");

        for(Person p : people.values()) {
            System.out.println(p.getId() + " " + p.getName());
        }

        System.out.println("===Find person by ID===");



    }

}