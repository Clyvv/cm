package com.citysoft.cm.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citysoft.cm.dto.PersonDto;
import com.citysoft.cm.service.IPersonService;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping
    public Set<PersonDto> getPersons() {
        return personService.fetch();
    }
	@GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable int id) {
        return personService.get(id);
    }
	
	@PostMapping
    public PersonDto createTitle(@RequestBody PersonDto dto) {
        return personService.create(dto);
    }
	
	@PutMapping("/{id}")
    public PersonDto putTitle(@PathVariable int id, @RequestBody PersonDto dto) {
        return personService.update(dto);
    }
	@DeleteMapping("/{id}")
    public void deleteTitle(@PathVariable int id) {
         try {
        	 personService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
