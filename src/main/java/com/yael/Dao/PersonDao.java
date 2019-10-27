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

    public Collection<Person> getAllPeople() {
        return this.people.values();
    }

}
