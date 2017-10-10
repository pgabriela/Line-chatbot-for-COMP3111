package com.example.bot.spring;

import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.net.URISyntaxException;
import java.net.URI;
import java.util.Iterator;

@Slf4j
public class SQLDatabaseEngine extends DatabaseEngine {

	@Override
	String search(String text) throws Exception {

		String result = null;

		Iterable<DictionaryBot> i = KitchenSinkApplication.dictRepo.findByKeyword(text);
		
		for(Iterator<DictionaryBot> iter = i.iterator(); iter.hasNext();){
			result = iter.next().getResponse();
		}

		if(result != null) {
			return result;
		}
		throw new Exception("NOT FOUND");
	}
	
}
