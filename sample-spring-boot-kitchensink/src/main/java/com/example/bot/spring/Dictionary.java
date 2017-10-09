package com.example.bot.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dictionary {

	@Id
	int id;
	private String keyword;
	private String response;

	public Dictionary(int id, String k, String r){
		this.id = id;
		this.keyword = k;
		this.response = r;
	}

	public void setKwd(String k){
		this.keyword = k;
	}
	public void setRsp(String r){
		this.response= r;
	}
	public void setId(int i){
		this.id = i;
	}
	public String getKwd(){
		return keyword;
	}
	public String getRsp(){
		return response;
	}
	public int getId(){
		return id;
	}

}
