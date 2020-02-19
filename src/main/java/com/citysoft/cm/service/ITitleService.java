package com.citysoft.cm.service;

import java.util.Set;

import com.citysoft.cm.dto.TitleDto;

public interface ITitleService {

	public TitleDto create(TitleDto titleDto);
	public TitleDto update(TitleDto titleDto);
	public TitleDto get(int id);
	public Set<TitleDto> fetch();
	public void delete(int id) throws Exception;
}
