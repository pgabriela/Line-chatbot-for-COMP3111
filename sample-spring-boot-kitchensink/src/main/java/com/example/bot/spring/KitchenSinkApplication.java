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
import com.example.bot.spring.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KitchenSinkApplication {
    static Path downloadedContentDir;
    static String tester = "";
    static DictionaryRepository dictRepo;

    public static void main(String[] args) throws IOException {
        downloadedContentDir = Files.createTempDirectory("line-bot");
	//dictRepo = (DictionaryRepository) SpringApplication.run(KitchenSinkApplication.class, args).getBean("dictionaryRepository");
	ApplicationContext ctx = SpringApplication.run(KitchenSinkApplication.class, args);

	dictRepo = (DictionaryRepository) ctx.getBean("dictionaryRepository");
	Iterable<Dictionary> i = dictRepo.findAll();
	Iterator<Dictionary> iter = i.iterator();

	if(!iter.hasNext()){
		Dictionary d1 = new Dictionary("kwd1", "rsp1");
		dictRepo.save(d1);
		Dictionary d2 = new Dictionary("kwd2", "rsp2");
		dictRepo.save(d2);
		Dictionary d3 = new Dictionary("kwd3", "rsp3");
		dictRepo.save(d3);
		Dictionary d4 = new Dictionary("kwd4", "rsp4");
		dictRepo.save(d4);
		Dictionary d5 = new Dictionary("kwd5", "rsp5");
		dictRepo.save(d5);
	}
	Iterable<Dictionary> ib = dictRepo.findAll();
	tester = dictRepo.findAll().getClass().getName();
	Iterator<Dictionary> iterb = ib.iterator();
	if(iterb.hasNext()){
		Dictionary d6 = new Dictionary("kwd6", "rsp6");
		dictRepo.save(d6);
	}
	Iterable<Dictionary> ic = dictRepo.findAll();
	Iterator<Dictionary> iterc = ic.iterator();
	/*
	if(iterc.hasNext()){
		tester = iterb.next().getResponse();
	}
	*/
    }
}
