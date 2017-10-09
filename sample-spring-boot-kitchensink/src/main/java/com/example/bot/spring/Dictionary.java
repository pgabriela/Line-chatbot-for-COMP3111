package com.example.bot.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dictionary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String keyword;
	private String response;

	public Dictionary(String k, String r){
		this.keyword = k;
		this.response = r;
	}

	public void setKeyword(String k){
		this.keyword = k;
	}
	public void setResponse(String r){
		this.response= r;
	}
	public void setId(int i){
		this.id = i;
	}
	public String getKeyword(){
		return this.keyword;
	}
	public String getResponse(){
		return this.response;
	}
	public int getId(){
		return this.id;
	}

}
