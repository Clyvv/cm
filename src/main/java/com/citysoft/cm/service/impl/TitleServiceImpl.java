package com.citysoft.cm.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citysoft.cm.dto.TitleDto;

import com.citysoft.cm.mapper.TitleMapper;
import com.citysoft.cm.model.Title;
import com.citysoft.cm.repository.TitleRepository;
import com.citysoft.cm.service.ITitleService;

@Service
public class TitleServiceImpl implements ITitleService{
	
	@Autowired
	public TitleRepository titleRepository;
	
	
	@Autowired
	public TitleMapper titleMapper;

	@Override
	public TitleDto create(TitleDto titleDto) {
		Title title = titleMapper.convertToEntity(titleDto);
		return titleMapper.convertToDto(titleRepository.save(title));
	}

	@Override
	public TitleDto update(TitleDto titleDto) {
		if (titleRepository.existsById(titleDto.getId())) {
			Title title = titleMapper.convertToEntity(titleDto);
			
			return titleMapper.convertToDto(titleRepository.save(title));
		}else {
			return null;
		}
		
		
	}

	@Override
	public TitleDto get(int id) {
		if(titleRepository.existsById(id)) {
			return titleMapper.convertToDto(titleRepository.getOne(id));
		}else {
			return null;
		}
	}

	@Override
	public void delete(int id) throws Exception {
		if(titleRepository.existsById(id)) {
			titleRepository.deleteById(id);
		}else {
			throw new Exception("Title "+id+ " not found");
		}
		
	}

	@Override
	public Set<TitleDto> fetch() {
		return titleMapper.convertToDto(titleRepository.findAll());
	}


}
