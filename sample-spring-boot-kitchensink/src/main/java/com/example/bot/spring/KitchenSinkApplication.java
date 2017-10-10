/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.bot.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.bot.spring.DictionaryBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KitchenSinkApplication {
    static Path downloadedContentDir;
    static DictionaryBotRepository dictRepo;

    public static void main(String[] args) throws IOException {
        downloadedContentDir = Files.createTempDirectory("line-bot");
	ApplicationContext ctx = SpringApplication.run(KitchenSinkApplication.class, args);

	dictRepo = (DictionaryBotRepository) ctx.getBean("dictionaryBotRepository");

	Iterable<DictionaryBot> i = dictRepo.findAll();
	Iterator<DictionaryBot> iter = i.iterator();

	if(!iter.hasNext()){
		DictionaryBot d1 = new DictionaryBot();
		d1.setKeyword("kwd1");
		d1.setResponse("rsp1");
		dictRepo.save(d1);
		DictionaryBot d2 = new DictionaryBot();
		d2.setKeyword("kwd2");
		d2.setResponse("rsp2");
		dictRepo.save(d2);
		DictionaryBot d3 = new DictionaryBot();
		d3.setKeyword("kwd3");
		d3.setResponse("rsp3");
		dictRepo.save(d3);
	}
	i = dictRepo.findAll();
	iter = i.iterator();
	if(iter.hasNext()){
		DictionaryBot d6 = new DictionaryBot();
		d6.setKeyword("kwd6");
		d6.setResponse("rsp6");
		d6 = dictRepo.save(d6);
	}
    }
}
