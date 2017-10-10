package com.example.bot.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DictionaryBot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String keyword;
	private String response;

	public DictionaryBot(){}

	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	public void setResponse(String response){
		this.response= response;
	}
	public void setId(long id){
		this.id = id;
	}
	public String getKeyword(){
		return keyword;
	}
	public String getResponse(){
		return response;
	}
	public long getId(){
		return id;
	}

}
