package com.example.bot.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {
	// public List<Dictionary> findByKeyword(String keyword);	
}
