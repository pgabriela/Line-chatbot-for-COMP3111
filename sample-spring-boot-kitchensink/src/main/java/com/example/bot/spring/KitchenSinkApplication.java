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
    static String tester = "";
    static DictionaryBotRepository dictRepo;

    public static void main(String[] args) throws IOException {
        downloadedContentDir = Files.createTempDirectory("line-bot");
	//dictRepo = (DictionaryRepository) SpringApplication.run(KitchenSinkApplication.class, args).getBean("dictionaryRepository");
	ApplicationContext ctx = SpringApplication.run(KitchenSinkApplication.class, args);

	dictRepo = (DictionaryBotRepository) ctx.getBean("dictionaryBotRepository");
	Iterable<DictionaryBot> i = dictRepo.findAll();
	tester += dictRepo.findAll().getClass().getName();
	Iterator<DictionaryBot> iter = i.iterator();
	tester += ",next ";
	tester += iter.hasNext();

	if(!iter.hasNext()){
		DictionaryBot d1 = new DictionaryBot();
		d1.setKeyword("kwd1");
		d1.setResponse("rsp1");
		d1 = dictRepo.save(d1);
		DictionaryBot d2 = new DictionaryBot();
		d2.setKeyword("kwd2");
		d2.setResponse("rsp2");
		d2 = dictRepo.save(d2);
		DictionaryBot d3 = new DictionaryBot();
		d3.setKeyword("kwd3");
		d3.setResponse("rsp3");
		d3 = dictRepo.save(d3);
		DictionaryBot d4 = new DictionaryBot();
		d4.setKeyword("kwd4");
		d4.setResponse("rsp4");
		d4 = dictRepo.save(d4);
		DictionaryBot d5 = new DictionaryBot();
		d5.setKeyword("kwd5");
		d5.setResponse("rsp5");
		d5 = dictRepo.save(d5);
		DictionaryBot d7 = new DictionaryBot();
		d7.setKeyword("kwd7");
		d7.setResponse("rsp7");
		d7 = dictRepo.save(d7);
	}
	tester += ",next ";
	i = dictRepo.findAll();
	tester += i.getClass().getName();
	tester += ", next ";
	tester += dictRepo.findAll().getClass().getName();
	iter = i.iterator();
	if(iter.hasNext()){
		DictionaryBot d6 = new DictionaryBot();
		d6.setKeyword("kwd6");
		d6.setResponse("rsp6");
		d6 = dictRepo.save(d6);
	}
	//Iterable<Dictionary> ic = dictRepo.findAll();
	//Iterator<Dictionary> iterc = ic.iterator();
	/*
	if(iterc.hasNext()){
		tester = iterb.next().getResponse();
	}
	*/
    }
}
