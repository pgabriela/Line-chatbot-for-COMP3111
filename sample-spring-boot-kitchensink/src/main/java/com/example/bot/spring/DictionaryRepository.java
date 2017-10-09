package com.example.bot.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {
	public String findByKeyword(String keyword);	
}
