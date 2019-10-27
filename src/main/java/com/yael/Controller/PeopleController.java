package com.yael.Controller;

import com.yael.Entity.Person;
import com.yael.Service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> getAllPeople() {
        return peopleService.getAllPeople();
    }

}
