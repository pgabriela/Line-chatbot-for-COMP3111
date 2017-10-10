package com.example.bot.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DictionaryBotRepository extends CrudRepository<DictionaryBot, Long> {
	List<DictionaryBot> findByKeyword(String keyword);	
}
