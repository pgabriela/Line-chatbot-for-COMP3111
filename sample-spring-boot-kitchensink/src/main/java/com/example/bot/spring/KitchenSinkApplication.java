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

	// Only for development testing
	Iterable<DictionaryBot> i = dictRepo.findAll();
	Iterator<DictionaryBot> iter = i.iterator();

	if(!iter.hasNext()){
		dictRepo.save(new DictionaryBot("kwd1", "rsp1"));
		dictRepo.save(new DictionaryBot("kwd2", "rsp2"));
		dictRepo.save(new DictionaryBot("kwd3", "rsp3"));
	}
    }
}
