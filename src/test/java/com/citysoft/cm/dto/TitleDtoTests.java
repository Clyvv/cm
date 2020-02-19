package com.citysoft.cm.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citysoft.cm.mapper.TitleMapper;
import com.citysoft.cm.model.Title;

@SpringBootTest
public class TitleDtoTests {

	@Autowired
    private TitleMapper titleMapper;
	
	
    
    @Test
    public void whenConvertTitleEntityToTitleDto_thenCorrect() {
        Title title = new Title();
        title.setId(1);
        title.setName("Herr");
 
        TitleDto titleDto = titleMapper.convertToDto(title);
        assertEquals(title.getId(), titleDto.getId());
        assertEquals(title.getName(), titleDto.getName());
    }

}
