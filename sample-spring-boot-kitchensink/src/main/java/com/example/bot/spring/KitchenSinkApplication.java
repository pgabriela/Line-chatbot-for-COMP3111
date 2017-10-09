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

@SpringBootApplication
public class KitchenSinkApplication {
    static Path downloadedContentDir;

    public static void main(String[] args) throws IOException {
        downloadedContentDir = Files.createTempDirectory("line-bot");
	DictionaryRepository dictRepo = (DictionaryRepository) SpringApplication.run(KitchenSinkApplication.class, args).getBean("dictionaryRepository");

	Iterable<Dictionary> i = dictRepo.findAll();
	Iterator<Dictionary> iter = i.iterator();

	if(!iter.hasNext()){
		dictRepo.save(new Dictionary(0, "kwd1", "rsp1"));
		dictRepo.save(new Dictionary(1, "kwd2", "rsp2"));
		dictRepo.save(new Dictionary(2, "kwd3", "rsp3"));
		dictRepo.save(new Dictionary(3, "kwd4", "rsp4"));
		dictRepo.save(new Dictionary(4, "kwd5", "rsp5"));
	}
    }
}
