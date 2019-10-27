package com.yael.Service;

import com.yael.Dao.PersonDao;
import com.yael.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PeopleService {

    @Autowired
    private PersonDao personDao;

    public Collection<Person> getAllPeople() {
        return personDao.getAllPeople();
    }


}
