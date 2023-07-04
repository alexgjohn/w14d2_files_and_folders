package com.codeclan.example.FilesAndFolders.controllers;

import com.codeclan.example.FilesAndFolders.models.Person;
import com.codeclan.example.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPerson(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/persons/{id}")
    public String deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return String.format("Person id %s deleted.", id);
    }
}
