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

import com.citysoft.cm.dto.TitleDto;
import com.citysoft.cm.service.ITitleService;

@RestController
@RequestMapping("/api/v1/titles")
public class TitleController {
	
	@Autowired
	private ITitleService titleService;
	
	@GetMapping
    public Set<TitleDto> getTitles() {
        return titleService.fetch();
    }
	@GetMapping("/{id}")
    public TitleDto getTitle(@PathVariable int id) {
        return titleService.get(id);
    }
	
	@PostMapping
    public TitleDto createTitle(@RequestBody TitleDto dto) {
        return titleService.create(dto);
    }
	
	@PutMapping("/{id}")
    public TitleDto putTitle(@PathVariable int id, @RequestBody TitleDto dto) {
        return titleService.update(dto);
    }
	@DeleteMapping("/{id}")
    public void deleteTitle(@PathVariable int id) {
         try {
			titleService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
