package com.example.bot.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DictionaryRepository extends Repository<Dictionary, Long> {
	List<Dictionary> findByKeyword(String keyword);	
	List<Dictionary> findAll();	
	Dictionary save(Dictionary dictionary);
}
